package product_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_management.model.Product;
import product_management.repository.IProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository settingRepository;

    @Override
    public List<Product> findAll() {
        return settingRepository.findAll();
    }

    @Override
    public void save(Product product) {
        settingRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return settingRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        settingRepository.update(product);
    }

    @Override
    public void remove(int id) {
        settingRepository.remove(id);
    }

    @Override
    public Product findByName(String name) {
        return settingRepository.findByName(name);
    }
}
