package com.example.bookingserver.networkmanager;

import com.example.bookingserver.dto.CarResponseDto;
import com.example.bookingserver.dto.CustomerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "customer-app")
public interface CustomerFeignClient {
    @GetMapping("/customer/find-customer/{customerId}")
    ResponseEntity<CustomerResponseDto> findCarById(@PathVariable Long customerId);
}
