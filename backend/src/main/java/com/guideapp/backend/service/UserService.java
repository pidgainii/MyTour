package com.guideapp.backend.service;

import com.guideapp.backend.entity.User;
import com.guideapp.backend.exception.AuthenticationException;
import com.guideapp.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser"))
        {
            throw new AuthenticationException("Authentication error", "UNAUTHORIZED", HttpStatus.UNAUTHORIZED);
        }

        User user = (User) authentication.getPrincipal();
        return user;
    }
}
