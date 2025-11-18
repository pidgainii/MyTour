package com.guideapp.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(String message, String errorcode, HttpStatus status) {
        super(message, errorcode, status);
    }
}
