package com.example.demo.storage;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerStorage {
    Customer create(Customer customer);
    Customer readById(Integer id);
    List<Customer> readAll();
    Customer update(Customer customer);
    Customer deleteCustomer(Integer customerID);
}
