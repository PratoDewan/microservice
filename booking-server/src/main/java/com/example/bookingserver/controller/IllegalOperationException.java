package com.example.bookingserver.controller;

public class IllegalOperationException extends RuntimeException{
    public IllegalOperationException(String message){
        super(message);
    }
}
