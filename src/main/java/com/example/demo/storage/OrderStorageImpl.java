package com.example.demo.storage;

import com.example.demo.OrderNotFoundException;
import com.example.demo.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class OrderStorageImpl implements OrderStorage {
    private Map<Integer, Order> orders = new HashMap<>();
    private CustomerStorageImpl customerStorage;
    private int idGen = 1;

    @Autowired
    public OrderStorageImpl(CustomerStorageImpl customerStorage) {
        this.customerStorage = customerStorage;
    }

    @Override
    public Order createOrder(Order order, Integer customerId) {

        customerStorage.customerExist(customerId);

        if (order == null) {
            throw new IllegalArgumentException("Customer must not be null");
        }

        return orders.put(idGen++, order);
    }

    @Override
    public List<Order> readAll() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public Order readById(Integer orderId) {
        orderExist(orderId);
        return orders.get(orderId);

    }

    @Override
    public Order updateOrder(Order order) {
        orderExist(order.getOrderId());

        return orders.put(order.getOrderId(), order);
    }

    @Override
    public Order delete(Order order) {
        orderExist(order.getOrderId());

        return orders.remove(order.getOrderId());
    }

    @Override
    public List<Order> getOrderByCustomerAndDate(Integer customerId, Integer day, Integer month, Integer year) {
        List<Order> orderByCustomer = new ArrayList<>(customerStorage.getOrdersByCustomerId(customerId));
        return orderByCustomer.stream()
                .filter(o -> Objects.equals(o.getRegOrder(), LocalDate.of(year, month, day)))
                .collect(Collectors.toList());
    }

    public void orderExist(Integer orderId) {
        if (!orders.containsKey(orderId)) {
            log.info("");
            throw new OrderNotFoundException("Order не найден");
        }
    }
}
