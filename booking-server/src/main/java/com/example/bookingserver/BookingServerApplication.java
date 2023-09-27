package com.example.bookingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingServerApplication.class, args);
	}

}
