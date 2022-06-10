package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeeModel;
import com.example.demo.util.ConnectionHelper;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlEmployeeModel implements EmployeeModel {
    @Override
    public Employee save(Employee employee) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "INSERT INTO employees " +
                    "(name, salary) " +
                    "values " +
                    "(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setDouble(2,employee.getSalary());
            preparedStatement.execute();
            System.out.println("Action success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Employee update(Employee employee, int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "UPDATE employees "+
                    "set name = ?, salary = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setDouble(2,employee.getSalary());
            preparedStatement.execute();
            System.out.println("Success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;    }

    @Override
    public Employee delete(int id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from employees";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                Employee employee = new Employee();
                employee.setName(name);
                employee.setSalary(salary);
                list.add(employee);
            }
            System.out.println("Success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;    }

    @Override
    public Employee findById(int id) {
        return null;
    }
}
