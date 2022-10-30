package com.example.practice.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
        private Map<ProductDto, Integer> products = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> products) {
        this.products = products;
    }

    public Map<ProductDto, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<ProductDto, Integer> products) {
        this.products = products;
    }

    public void addProduct(ProductDto product) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }

    public long getTotal(Long id) {
        long total = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(id)) {
                total = entry.getKey().getPrice() * entry.getValue();
            }
        }
        return total;
    }

    public long getTotalPrice() {
        long totalPrice = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrice;
    }

}
