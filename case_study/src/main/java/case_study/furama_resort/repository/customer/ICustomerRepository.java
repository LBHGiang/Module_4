package case_study.furama_resort.repository.customer;

import case_study.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select c.* from `customer` c inner join `customer_type` ct " +
            "on c.customer_type_id = ct.id " +
            "where c.name like %:name% and c.email like %:email% and ct.name like %:typeName% and c.status= 1", nativeQuery = true)
    Page<Customer> findByNameAndEmailAndCustomerType(@Param("name") String name,
                                                     @Param("email") String email,
                                                     @Param("typeName") String typeName,
                                                     Pageable pageable);

    @Query(value = "select * from `customer` where id=:id and status = 1", nativeQuery = true)
    Optional<Customer> findById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update customer set status = 0 where id = :id", nativeQuery = true)
    void remove(@Param("id") int id);

    @Query(value = "select * from `customer` where status= 1", nativeQuery = true)
    List<Customer> findAllCustomer();

//    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO customer ( name, date_of_birth,gender,id_card, phone_number, email, address, customer_type_id, status)\n" +
//            "VALUE ( :name, :date_of_birth,:gender,:id_card, :phone_number, :email, :address, :customer_type_id, :status)", nativeQuery = true)
//    void save(@Param("name") String name,
//              @Param("date_of_birth") Date dateOfBirth,
//              @Param("gender") int gender,
//              @Param("id_card") String idCard,
//              @Param("phone_number") String phoneNumber,
//              @Param("email") String email,
//              @Param("address") String address,
//              @Param("customer_type_id") int customerTypeId,
//              @Param("status") int status);

}
