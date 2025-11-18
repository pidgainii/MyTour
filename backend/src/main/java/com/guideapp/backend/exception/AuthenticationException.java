package com.guideapp.backend.exception;

import org.springframework.http.HttpStatus;

public class AuthenticationException extends BaseException {
    public AuthenticationException(String message, String errorcode, HttpStatus status) {
        super(message, errorcode, status);
    }
}
