package customer_management.service;

import customer_management.model.Customer;
import customer_management.repository.ICustomerRepository;
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
        return settingRepository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        settingRepository.update(id, customer);
    }

    @Override
    public void remove(int id) {
        settingRepository.remove(id);
    }
}
