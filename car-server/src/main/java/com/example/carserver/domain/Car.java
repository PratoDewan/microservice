package com.example.carserver.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long carId;
    @Column(name = "brand")
    private String brand;
    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "rent_cost")
    private Integer rentCost;
    public Car(){

    }

    public Car(Long carId, String brand, String name, Integer quantity, Integer rentCost) {
        this.carId = carId;
        this.brand = brand;
        this.name = name;
        this.quantity = quantity;
        this.rentCost = rentCost;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getRentCost() {
        return rentCost;
    }

    public void setRentCost(Integer rentCost) {
        this.rentCost = rentCost;
    }
}
