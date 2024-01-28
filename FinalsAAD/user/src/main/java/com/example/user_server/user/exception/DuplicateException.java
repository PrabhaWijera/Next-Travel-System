package com.example.user_server.user.exception;

public class DuplicateException extends RuntimeException{
    public DuplicateException(String message){
        super(message);
    }
}
