package case_study.furama_resort.service.customer;

import case_study.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {

    void save(Customer customer);

    Optional<Customer> findById(int id);

    void remove(int id);

    Page<Customer> findByNameAndEmailAndCustomerType(String name,
                                                     String email,
                                                     String typeName,
                                                     Pageable pageable);
}
