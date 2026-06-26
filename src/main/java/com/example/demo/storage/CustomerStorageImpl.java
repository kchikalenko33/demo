package com.example.demo.storage;

import com.example.demo.CustomerNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class CustomerStorageImpl implements CustomerStorage {
    private final Map<Integer, Customer> customers = new HashMap<>();
    private int idGen = 1;

    @Override
    public Customer create(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer must not be null");
        }

        customer.setId(idGen++);
        customer.setRegDate(LocalDateTime.now());
        customers.put(customer.getId(), customer);

        log.info("Customer created with id={}", customer.getId());
        return customer;
    }

    @Override
    public Customer readById(Integer id) {
        customerExist(id);
        log.info("Customer с id {} получен", id);
        return customers.get(id);
    }

    @Override
    public List<Customer> readAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer update(Customer customer) {
        customerExist(customer.getId());
        customers.put(customer.getId(), customer);
        return customer;
    }

    @Override
    public Customer deleteCustomer(Integer customerID) {
        customerExist(customerID);
        return customers.remove(customerID);
    }

    public void customerExist(Integer customerId) {
        if (!customers.containsKey(customerId)) {
            log.info("Customer {} не найден", customerId);
            throw new CustomerNotFoundException("");
        }
    }

    public List<Order> getOrdersByCustomerId(Integer customerId) {
        customerExist(customerId);

        return new ArrayList<>(customers.get(customerId).getOrders());
    }
}
