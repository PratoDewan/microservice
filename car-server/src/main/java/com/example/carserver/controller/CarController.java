package com.example.carserver.controller;

import com.example.carserver.domain.Car;
import com.example.carserver.dto.CarBookingDto;
import com.example.carserver.dto.CarResponseDto;
import com.example.carserver.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars(){
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }
    @PostMapping("/add-car")
    public ResponseEntity<String> addNewCar(@RequestBody Car car){
        carService.addNewCar(car);
        return new ResponseEntity<>("Successfully Inserted", HttpStatus.OK);
    }
    @GetMapping("/find-car/{carId}")
    public ResponseEntity<CarResponseDto> findById(@PathVariable Long carId){
        return new ResponseEntity<>(carService.findCarById(carId),HttpStatus.OK);
    }
    @PutMapping("/update-quantity/{carId}")
    public ResponseEntity<Void> updateQuantity(@PathVariable Long carId){
        carService.updateQuantity(carId,"success");
        return ResponseEntity.ok().build();
    }
    @PutMapping("/revert-quantity/{carId}")
    public ResponseEntity<Void> revertQuantity(@PathVariable Long carId){
        carService.updateQuantity(carId,"failed");
        return ResponseEntity.ok().build();
    }
}
