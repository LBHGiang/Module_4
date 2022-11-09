package case_study.furama_resort.service.customer;

import case_study.furama_resort.model.customer.Customer;
import case_study.furama_resort.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }

    @Override
    public Page<Customer> findByNameAndEmailAndCustomerType(String name, String email, String typeName, Pageable pageable) {
        return customerRepository.findByNameAndEmailAndCustomerType(name, email, typeName, pageable);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAllCustomer();
    }
}
