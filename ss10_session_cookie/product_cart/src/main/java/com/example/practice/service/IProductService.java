package com.example.practice.service;

import com.example.practice.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);
}
