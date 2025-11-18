package com.guideapp.backend.exception;

import org.springframework.http.HttpStatus;

public class IncorrectPasswordException extends BaseException {
    public IncorrectPasswordException(String message, String errorcode, HttpStatus status) {
        super(message, errorcode, status);
    }
}
