package com.example.carserver.service;

import com.example.carserver.domain.Car;
import com.example.carserver.dto.CarResponseDto;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> getAllCars();
    CarResponseDto findCarById(Long carId);
    void addNewCar(Car car);
    void updateQuantity(Long carId,String operation);
}
