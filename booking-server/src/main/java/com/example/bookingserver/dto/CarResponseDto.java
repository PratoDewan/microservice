package com.example.bookingserver.dto;

public class CarResponseDto {
    private Long carId;
    private String brand;
    private String name;
    private Integer quantity;
    private Integer rentCost;
    public CarResponseDto(){

    }

    public CarResponseDto(Long carId, String brand, String name, Integer quantity,Integer rentCost) {
        this.carId = carId;
        this.brand = brand;
        this.name = name;
        this.quantity = quantity;
        this.rentCost=rentCost;
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
