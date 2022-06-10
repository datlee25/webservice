package com.example.demo.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    public int id;
    public String name;
    public double salary;
}
