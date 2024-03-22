package com.example.TBTDD.domain.exception;

public class InvalidClientIdException extends RuntimeException {

    public InvalidClientIdException(String message) {
        super(message);
    }
}
