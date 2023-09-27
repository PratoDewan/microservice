package com.example.bookingserver.networkmanager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "PAYMENT-APP")
public interface PaymentFeignClient {
    @PutMapping("/payment/update/{userId}/{cost}")
    ResponseEntity<Boolean> deductBalance(@PathVariable Long userId,@PathVariable Integer cost);
}