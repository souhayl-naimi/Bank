package io.naimi.bank.DAO;

import io.naimi.bank.Entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation,Long> {

    @Query("select o from Operation o where o.account.accountCode=:x order by o.operationDate desc")
    public Page<Operation> listOperation(@Param("x")String accountCode, Pageable pageable);

}
