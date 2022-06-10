package com.example.demo.repository;

import com.example.demo.entity.Product;
import com.example.demo.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductModel implements com.example.demo.model.ProductModel {
    @Override
    public Product save(Product product) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "INSERT INTO products " +
                    "(name, price) " +
                    "values " +
                    "(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.execute();
            System.out.println("Action success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Product update(Product product, int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "UPDATE products "+
                    "set name = ?, price = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.execute();
            System.out.println("Success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Product delete(int id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from products";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                Product product = new Product();
                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                list.add(product);
            }
            System.out.println("Success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Product findById(int id) {
        return null;
    }
}
