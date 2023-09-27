package com.example.customerserver.controller;

import com.example.customerserver.domain.CustomerEntity;
import com.example.customerserver.dto.CustomerResponseDto;
import com.example.customerserver.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/all")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }
    @PostMapping("/add-customer")
    public ResponseEntity<String> addNewCustomer(@RequestBody CustomerEntity customerEntity){
        customerService.addNewCustomer(customerEntity);
        return new ResponseEntity<>("Successfully Inserted", HttpStatus.OK);
    }
    @GetMapping("/find-customer/{customerId}")
    public ResponseEntity<CustomerResponseDto> findById(@PathVariable Long customerId){
        return new ResponseEntity<>(customerService.findCustomerById(customerId),HttpStatus.OK);
    }
}
