package com.example.demo.service;

import com.example.demo.model.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto, Integer customerId);

    List<OrderDto> readAll();

    OrderDto readById(Integer orderId);

    OrderDto updateOrder(OrderDto orderDto);

    OrderDto delete(OrderDto orderDto);

    List<OrderDto> getOrderByCustomerAndDate(Integer customerId, Integer day, Integer month, Integer year);
}

