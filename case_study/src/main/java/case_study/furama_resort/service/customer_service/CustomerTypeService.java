package case_study.furama_resort.service.customer_service;

import case_study.furama_resort.model.customer.CustomerType;
import case_study.furama_resort.repository.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> getCustomerTypes() {
        return customerTypeRepository.getCustomerTypes();
    }
}
