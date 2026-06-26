package com.example.demo.storage;

import com.example.demo.model.Order;

import java.util.List;

public interface OrderStorage {

    Order createOrder(Order order, Integer customerId);

    List<Order> readAll();

    Order readById(Integer orderId);

    Order updateOrder(Order order);

    Order delete(Order order);

    List<Order> getOrderByCustomerAndDate(Integer customerId, Integer day, Integer month, Integer year);
}
