package com.example.demo.util;

import com.example.demo.model.Order;
import com.example.demo.model.OrderDto;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class OrderMapper {

    public Order fromDto(OrderDto orderDto) {
        return Order.builder()
                .orderId(orderDto.getOrderId())
                .name(orderDto.getName())
                .amount(orderDto.getAmount())
                .count(orderDto.getCount())
                .regOrder(LocalDate.now())
                .build();
    }

    public OrderDto toDto(Order order) {
        return OrderDto.builder()
                .orderId(order.getOrderId())
                .name(order.getName())
                .amount(order.getAmount())
                .count(order.getCount())
                .build();
    }

    public List<Order> fromListDto(List<OrderDto> ordersDto) {
        return ordersDto.stream()
                .map(orderDto -> fromDto(orderDto))
                .collect(Collectors.toList());
    }

    public List<OrderDto> toListDto(List<Order> orders) {
        return  orders.stream()
                .map(order -> toDto(order))
                .collect(Collectors.toList());
    }
}
