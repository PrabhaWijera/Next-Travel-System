package com.example.packageserver.package_server.exception;

public class DuplicateException extends RuntimeException{

    public DuplicateException (String message){
        super(message);
    }
}
