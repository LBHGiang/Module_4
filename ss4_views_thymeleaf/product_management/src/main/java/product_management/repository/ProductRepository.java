package product_management.repository;

import org.springframework.stereotype.Repository;
import product_management.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Bàn phím", 5000, "Xịn", "A1"));
        products.add(new Product(2, "Chuột", 6000, "Xịn", "A5"));
        products.add(new Product(3, "Màn hình", 15000, "Xịn", "B2"));
        products.add(new Product(4, "Lót chuột", 1000, "Xịn", "B4"));
        products.add(new Product(5, "Camera", 6000, "Xịn", "C0"));
        products.add(new Product(6, "IPhone", 7000, "Xịn", "A6"));
    }

    public int getAutoIncrementId() {
        int maxId = 0;
        for (Product product : products
        ) {
            if (product.getId() > maxId) {
                maxId = product.getId();
            }
        }
        return maxId + 1;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        product.setId(getAutoIncrementId());
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        products.remove(findById(product.getId()));
        products.add(product);
    }

    @Override
    public void remove(int id) {
        products.remove(findById(id));
    }

    @Override
    public Product findByName(String name) {
        for (Product product : products) {
            if (product.getName().contains(name)) {
                return product;
            }
        }
        return null;
    }

}
