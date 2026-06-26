package com.example.demo.service;

import com.example.demo.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl2 implements CustomerService{


    @Override
    public CustomerDto create(CustomerDto customerDto) {
        return null;
    }

    @Override
    public List<CustomerDto> readAll() {
        return List.of();
    }

    @Override
    public CustomerDto readById(Integer customerId) {
        return null;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public CustomerDto deleteCustomer(Integer customerID) {
        return null;
    }
}
