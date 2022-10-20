package exercise.customer_management.repository;

import exercise.customer_management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByNameContaining(String searchName);
}
