package com.example.carserver.service.Impl;

import com.example.carserver.domain.Car;
import com.example.carserver.dto.CarResponseDto;
import com.example.carserver.exception.CarNotFoundException;
import com.example.carserver.repository.CarRepository;
import com.example.carserver.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public CarResponseDto findCarById(Long carId) {
        return carRepository.findById(carId)
                .map(car -> {
                    CarResponseDto carResponseDto = new CarResponseDto();
                    carResponseDto.setCarId(car.getCarId());
                    carResponseDto.setBrand(car.getBrand());
                    carResponseDto.setName(car.getName());
                    carResponseDto.setQuantity(car.getQuantity());
                    carResponseDto.setRentCost(car.getRentCost());
                    return carResponseDto;
                })
                .orElseThrow(() -> new CarNotFoundException("Car not found with ID: " + carId));
    }

    @Override
    public void addNewCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void updateQuantity(Long carId,String operation) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        if(optionalCar.isPresent()) {
            Car car = optionalCar.get();
            if (operation.equals("success")) {
                car.setQuantity(car.getQuantity() - 1);
            } else {
                car.setQuantity(car.getQuantity()+1);
            }
            carRepository.save(car);
        }
    }
}
