package com.example.demo.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    public int id;
    public String name;
    public double price;
}
