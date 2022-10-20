package exercise.customer_management.service;

import exercise.customer_management.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ICustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(Customer customer);

    List<Customer> findByName(String searchName);
}
