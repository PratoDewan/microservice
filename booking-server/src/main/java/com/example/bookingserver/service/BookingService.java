package com.example.bookingserver.service;

import com.example.bookingserver.domain.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getBookingList();
    void reserveCar(Long carId,Long customerId);
}
