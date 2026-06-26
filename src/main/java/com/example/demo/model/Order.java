package com.example.demo.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private int orderId;
    private String name;
    private double amount;
    private int count;
    private LocalDate regOrder;
}
