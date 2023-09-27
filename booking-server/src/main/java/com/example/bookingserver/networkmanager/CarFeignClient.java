package com.example.bookingserver.networkmanager;

import com.example.bookingserver.dto.CarResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

@FeignClient(name = "car-app")
public interface CarFeignClient {
    @GetMapping("/car/find-car/{carId}")
    ResponseEntity<CarResponseDto> findCarById(@PathVariable Long carId);
    @PutMapping("/car/update-quantity/{carId}")
    ResponseEntity<Void> updateCar(@PathVariable Long carId);
    @PutMapping("/car/revert-quantity/{carId}")
    ResponseEntity<Void> revertCar(@PathVariable Long carId);
}
