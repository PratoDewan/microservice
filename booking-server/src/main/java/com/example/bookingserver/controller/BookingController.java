package com.example.bookingserver.controller;

import com.example.bookingserver.domain.Booking;
import com.example.bookingserver.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    public BookingService bookingService;
    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookingList(){
        return new ResponseEntity<>(bookingService.getBookingList(), HttpStatus.OK);
    }
    @PostMapping("/{carId}/{customerId}")
    public ResponseEntity<String> bookCar(@PathVariable Long carId, @PathVariable Long customerId){
        bookingService.reserveCar(carId,customerId);
        return new ResponseEntity<>("Successfully Reserved", HttpStatus.OK);
    }
}
