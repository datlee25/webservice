package com.example.demo.model;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductModel {
    Product save(Product product);
    Product update(Product product, int id);
    Product delete(int id);
    List<Product> findAll();
    Product findById(int id);
}
