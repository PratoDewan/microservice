package com.example.carserver.repository;

import com.example.carserver.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
