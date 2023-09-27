package com.example.carserver.dto;

public class CarBookingDto {
    private Long carId;
    private Integer quantity;
    public CarBookingDto(){

    }

    public CarBookingDto(Long carId, Integer quantity) {
        this.carId = carId;
        this.quantity = quantity;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
