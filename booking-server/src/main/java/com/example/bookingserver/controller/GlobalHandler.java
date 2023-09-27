package com.example.bookingserver.controller;

import com.example.bookingserver.exception.CarNotFoundException;
import com.example.bookingserver.exception.CustomerNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(IllegalOperationException.class)
    public ResponseEntity<?> handleIllegalException(IllegalOperationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<?> handleCarNotFoundException(CarNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
