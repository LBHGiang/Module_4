package case_study.furama_resort.service.contract;

import case_study.furama_resort.model.contract.Contract;
import case_study.furama_resort.model.contract.ContractDetail;
import case_study.furama_resort.repository.contract.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public void remove(int id) {
        contractDetailRepository.remove(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<ContractDetail> findByContractId(int id) {
        return contractDetailRepository.findByContractId(id);
    }
}
