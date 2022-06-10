package com.example.demo.model;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeModel {
    Employee save(Employee employee);
    Employee update(Employee employee, int id);
    Employee delete(int id);
    List<Employee> findAll();
    Employee findById(int id);
}
