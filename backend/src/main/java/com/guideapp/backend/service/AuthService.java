package com.guideapp.backend.service;

import com.guideapp.backend.dto.request.LoginRequest;
import com.guideapp.backend.dto.request.SignUpRequest;
import com.guideapp.backend.dto.response.AuthResponse;
import com.guideapp.backend.entity.RevokedToken;
import com.guideapp.backend.exception.IncorrectPasswordException;
import com.guideapp.backend.exception.UserAlreadyExistsException;
import com.guideapp.backend.exception.UserNotFoundException;
import com.guideapp.backend.repository.TokenRepository;
import com.guideapp.backend.security.JwtService;
import com.guideapp.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.guideapp.backend.entity.User;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final String PASSWORD_PATTERN =
            "^(?=.*[A-Z])(?=.*\\d).{8,}$";

    private final UserRepository userRepo;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    // TODO: handle exception
    public AuthResponse login(LoginRequest loginRequest) {
        try
        {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            User user = userRepo.findByEmail(loginRequest.getEmail()).orElseThrow();

            // for security
            user.setPassword("");
            return new AuthResponse(user, jwtService.getToken(user));
        }
        catch (BadCredentialsException e)
        {
            throw new IncorrectPasswordException("Forbidden", "FORBIDDEN", HttpStatus.FORBIDDEN);
        }
        catch (InternalAuthenticationServiceException e)
        {
            throw new UserNotFoundException("Forbidden", "FORBIDDEN", HttpStatus.FORBIDDEN);
        }

    }

    public AuthResponse signup(SignUpRequest signUpRequest) {
        if (userRepo.findByUsername(signUpRequest.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("Conflict", "CONFLICT", HttpStatus.CONFLICT);
        }
        if (userRepo.findByEmail(signUpRequest.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Conflict", "CONFLICT", HttpStatus.CONFLICT);
        }
        if (!signUpRequest.getPassword().matches(PASSWORD_PATTERN)) {
            throw new IncorrectPasswordException("Bad request", "BAD_REQUEST", HttpStatus.BAD_REQUEST);
        }

        // Creating User Entity to save into BD
        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        user.setBio(signUpRequest.getBio());
        user.setEmail(signUpRequest.getEmail());
        user.setRole(signUpRequest.getRole());

        this.userRepo.save(user);

        //for security
        user.setPassword("");
        return new AuthResponse(user, jwtService.getToken(user));
    }
}
