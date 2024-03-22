package com.example.TBTDD.domain.exception;

public class NotContentResource extends RuntimeException{
    public NotContentResource(String message){
        super(message);
    }
}
