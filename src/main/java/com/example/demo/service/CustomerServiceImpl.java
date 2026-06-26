package com.example.demo.service;

import com.example.demo.model.CustomerDto;
import com.example.demo.storage.CustomerStorage;
import com.example.demo.util.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("Customer")
public class CustomerServiceImpl implements CustomerService {

    private CustomerStorage customerStorage;

    @Autowired
    public CustomerServiceImpl(CustomerStorage customerStorage) {
        this.customerStorage = customerStorage;
    }

    @Override
    public CustomerDto create(CustomerDto customerDto) {
        return CustomerMapper.customerToDto(customerStorage.create(CustomerMapper.customerFromDto(customerDto)));
    }

    @Override
    public List<CustomerDto> readAll() {
        return CustomerMapper.customersToDto(customerStorage.readAll());
    }

    @Override
    public CustomerDto readById(Integer customerId) {
        return CustomerMapper.customerToDto(customerStorage.readById(customerId));
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        return CustomerMapper.customerToDto(customerStorage.update(CustomerMapper.customerFromDto(customerDto)));
    }

    @Override
    public CustomerDto deleteCustomer(Integer customerID) {
        return CustomerMapper.customerToDto(customerStorage.deleteCustomer(customerID));
    }
}
