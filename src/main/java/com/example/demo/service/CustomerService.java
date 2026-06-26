package com.example.demo.service;

import com.example.demo.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    CustomerDto create(CustomerDto customerDto);
    List<CustomerDto> readAll();
    CustomerDto readById(Integer customerId);
    CustomerDto updateCustomer(CustomerDto customerDto);
    CustomerDto deleteCustomer(Integer customerID);
}
