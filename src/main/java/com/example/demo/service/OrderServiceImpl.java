package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.OrderDto;
import com.example.demo.storage.OrderStorage;
import com.example.demo.util.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderStorage orderStorage;

    public OrderServiceImpl(OrderStorage orderStorage) {
        this.orderStorage = orderStorage;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto, Integer customerId) {
        return OrderMapper.toDto(orderStorage.createOrder(OrderMapper.fromDto(orderDto), customerId));
    }

    @Override
    public List<OrderDto> readAll() {
        return OrderMapper.toListDto(orderStorage.readAll());
    }

    @Override
    public OrderDto readById(Integer orderId) {
        return OrderMapper.toDto(orderStorage.readById(orderId));
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        return OrderMapper.toDto(orderStorage.updateOrder(OrderMapper.fromDto(orderDto)));
    }

    @Override
    public OrderDto delete(OrderDto orderDto) {
        return OrderMapper.toDto(orderStorage.delete(OrderMapper.fromDto(orderDto)));
    }

    @Override
    public List<OrderDto> getOrderByCustomerAndDate(Integer customerId, Integer day, Integer month, Integer year) {
        return OrderMapper.toListDto(orderStorage.getOrderByCustomerAndDate(customerId, day, month, year));
    }
}
