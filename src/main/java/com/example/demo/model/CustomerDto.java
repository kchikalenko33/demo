package com.example.demo.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    private int id;
    private String name;
    private String surname;
    List<Order> orders;
}
