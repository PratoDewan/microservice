package com.example.customerserver.service.impl;

import com.example.customerserver.domain.CustomerEntity;
import com.example.customerserver.dto.CustomerResponseDto;
import com.example.customerserver.exception.CustomerNotFoundException;
import com.example.customerserver.repository.CustomerRepository;
import com.example.customerserver.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerResponseDto findCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .map(customerEntity -> {
                    CustomerResponseDto customerResponseDto = new CustomerResponseDto();
                    customerResponseDto.setCustomerId(customerEntity.getCustomerId());
                    customerResponseDto.setName(customerEntity.getName());
                    customerResponseDto.setEmail(customerEntity.getEmail());
                    return customerResponseDto;
                })
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));
    }

    @Override
    public void addNewCustomer(CustomerEntity customerEntity) {
        customerRepository.save(customerEntity);
    }
}
