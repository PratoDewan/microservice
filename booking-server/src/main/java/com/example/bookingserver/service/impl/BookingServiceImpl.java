package com.example.bookingserver.service.impl;

import com.example.bookingserver.config.TransactionConfiguration;
import com.example.bookingserver.controller.IllegalOperationException;
import com.example.bookingserver.domain.Booking;
import com.example.bookingserver.dto.CarResponseDto;
import com.example.bookingserver.dto.CustomerResponseDto;
import com.example.bookingserver.exception.CarNotFoundException;
import com.example.bookingserver.exception.CustomerNotFoundException;
import com.example.bookingserver.networkmanager.CarFeignClient;
import com.example.bookingserver.networkmanager.CustomerFeignClient;
import com.example.bookingserver.networkmanager.PaymentFeignClient;
import com.example.bookingserver.repository.BookingRepository;
import com.example.bookingserver.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerFeignClient customerFeignClient;
    @Autowired
    private CarFeignClient carFeignClient;
    @Autowired
    private TransactionConfiguration transactionConfiguration;
    @Autowired
    private PaymentFeignClient paymentFeignClient;

    @Override
    public List<Booking> getBookingList() {
        return bookingRepository.findAll();
    }

    @Override
    public void reserveCar(Long carId, Long customerId) {
        ResponseEntity<CarResponseDto> carResponse = carFeignClient.findCarById(carId);
        if (carResponse.getStatusCode().value() > 200) {
            throw new CarNotFoundException("There is no car with this " + carId);
        }
        CarResponseDto carResponseDto =
                carResponse.getBody() != null ? carResponse.getBody() : null;
        ResponseEntity<CustomerResponseDto> customerResponse = customerFeignClient.findCarById(customerId);
        if (customerResponse.getStatusCode().value() > 200) {
            throw new CustomerNotFoundException("There is no customer with this " + customerId);
        }
        CustomerResponseDto customerResponseDto =
                customerResponse.getBody() != null ? customerResponse.getBody() : null;
        if (carResponseDto.getQuantity() <= 0) {
            throw new IllegalOperationException("Error! This car is not available to rent");
        }
        carFeignClient.updateCar(carId);
        ResponseEntity<Boolean> paymentResponse = paymentFeignClient.deductBalance(customerId, carResponseDto.getRentCost());
        Boolean transaction = paymentResponse.getBody() != null ? paymentResponse.getBody() : null;
        if (transaction) {
            Booking booking = new Booking();
            booking.setCarId(carResponseDto.getCarId());
            booking.setCustomerId(customerResponseDto.getCustomerId());
            bookingRepository.save(booking);
        } else {
            carFeignClient.revertCar(carId);
        }
    }

}
