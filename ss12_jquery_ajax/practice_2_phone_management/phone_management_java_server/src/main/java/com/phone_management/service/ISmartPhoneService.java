package com.phone_management.service;

import com.phone_management.model.SmartPhone;

import java.util.List;
import java.util.Optional;

public interface ISmartPhoneService {

    List<SmartPhone> findAll();

    void save(SmartPhone smartPhone);

    Optional<SmartPhone> findById(Long id);

    void update(SmartPhone smartPhone);

    void remove(Long id);
}
