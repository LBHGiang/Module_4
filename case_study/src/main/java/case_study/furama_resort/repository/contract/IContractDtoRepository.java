package case_study.furama_resort.repository.contract;

import case_study.furama_resort.model.contract.Contract;
import case_study.furama_resort.model.dto.ContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface IContractDtoRepository extends JpaRepository<ContractDto, Integer> {

    @Query(value =
            "select c.*, (ifnull(cd.quantity * af.cost,0 ) + f.cost) as total " +
            "from contract c " +
            "left join contract_detail cd on c.id = cd.contract_id " +
            "left join attach_facility af on cd.attach_facility_id = af.id " +
            "left join facility f on c.facility_id = f.id " +
            "where c.status = 1 " +
            "group by c.id ", nativeQuery = true)
    Page<ContractDto> findAll(Pageable pageable);


    @Query(value =
            "select c.*, (ifnull(cd.quantity * af.cost,0 ) + f.cost) as total " +
                    "from contract c " +
                    "left join contract_detail cd on c.id = cd.contract_id " +
                    "left join attach_facility af on cd.attach_facility_id = af.id " +
                    "left join facility f on c.facility_id = f.id " +
                    "where c.status = 1 and c.id = :id " +
                    "group by c.id ", nativeQuery = true)
    Optional<ContractDto> findById(@Param("id") int id);

}
