package com.example.customerserver.service;

import com.example.customerserver.domain.CustomerEntity;
import com.example.customerserver.dto.CustomerResponseDto;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerEntity> getAllCustomers();
    CustomerResponseDto findCustomerById(Long customerId);
    void addNewCustomer(CustomerEntity customerEntity);
}
