package case_study.furama_resort.service.contract;

import case_study.furama_resort.model.contract.Contract;
import case_study.furama_resort.model.contract.ContractDetail;

import java.util.List;
import java.util.Optional;

public interface IContractDetailService {

    List<ContractDetail> findAll();

    void remove(int id);

    void save(ContractDetail contractDetail);

    List<ContractDetail> findByContractId(int id);
}
