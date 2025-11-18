package com.guideapp.backend.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends BaseException {
    public UserAlreadyExistsException(String message, String errorcode, HttpStatus status) {
        super(message, errorcode, status);
    }
}
