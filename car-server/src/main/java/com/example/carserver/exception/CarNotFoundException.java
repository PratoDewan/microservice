package com.example.carserver.exception;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(String message){
        super(message);
    }
}
