package com.example.bookingserver.exception;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(String message){
        super(message);
    }
}
