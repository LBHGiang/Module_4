package exercise.customer_management.service;


import exercise.customer_management.model.Customer;
import exercise.customer_management.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository settingRepository;


    @Override
    public List<Customer> findAll() {
        return settingRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        settingRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return settingRepository.findById(id).orElse(null);
    }

    @Override
    public void update(int id, Customer customer) {
        settingRepository.save(customer);
    }

    @Override
    public void remove(Customer customer) {
        settingRepository.delete(customer);
    }

    @Override
    public List<Customer> findByName(String searchName) {
        return settingRepository.findByNameContaining(searchName);
    }
}
