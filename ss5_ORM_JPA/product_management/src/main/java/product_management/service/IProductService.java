package product_management.service;

import product_management.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(Product product);

    List<Product> findByName(String name);
}
