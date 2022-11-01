package com.phone_management.repository;

import com.phone_management.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ISmartPhoneRepository extends JpaRepository<SmartPhone, Long> {

    @Transactional
    @Modifying
    @Query(value = "delete from smartphone where id = :id", nativeQuery = true)
    void deleteSmartPhoneById(@Param("id") Long id);
}
