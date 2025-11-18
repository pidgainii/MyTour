package com.guideapp.backend.controller;


import com.guideapp.backend.entity.User;
import com.guideapp.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<User> getUser(){
        User user = userService.getCurrentUser();

        // for security
        user.setPassword("");
        return ResponseEntity.ok(user);
    }
}
