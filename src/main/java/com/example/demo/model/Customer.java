package com.example.demo.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    private int id;
    private String name;
    private String surname;
    List<Order> orders;
    LocalDateTime regDate;
}
