package com.example.demo.util;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerDto;
import lombok.Builder;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
@Builder
public class CustomerMapper {
    public Customer customerFromDto(CustomerDto customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .surname(customerDto.getSurname())
                .orders(customerDto.getOrders() == null ? new ArrayList<>() : customerDto.getOrders())
                .build();
    }

    public CustomerDto customerToDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .orders(customer.getOrders() == null ? new ArrayList<>() : customer.getOrders())
                .build();
    }

    public List<Customer> customersFromDto(List<CustomerDto> customersDto) {
        return customersDto.stream()
                .map(c -> customerFromDto(c))
                .collect(Collectors.toList());
    }

    public List<CustomerDto> customersToDto(List<Customer> customers) {
        return customers.stream()
                .map(c -> customerToDto(c))
                .collect(Collectors.toList());
    }
}
