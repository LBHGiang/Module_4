package case_study.furama_resort.repository.contract;

import case_study.furama_resort.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

    @Query(value = "select * from `contract_detail` where status= 1", nativeQuery = true)
    List<ContractDetail> findAll();

    @Transactional
    @Modifying
    @Query(value = "update `contract_detail` set status = 0 where id = :id", nativeQuery = true)
    void remove(@Param("id") int id);

    @Query(value = "select * from `contract_detail` where contract_id=:id and status = 1 group by attach_facility_id ", nativeQuery = true)
    List<ContractDetail> findByContractId(@Param("id") int id);
}
