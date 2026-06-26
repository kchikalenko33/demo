package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private int orderId;
    private String name;
    private double amount;
    private int count;
}