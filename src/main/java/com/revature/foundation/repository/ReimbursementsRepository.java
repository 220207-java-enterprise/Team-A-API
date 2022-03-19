package com.revature.foundation.repository;

import com.revature.foundation.models.Reimbursement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimbursementsRepository extends CrudRepository<Reimbursement, String> {


    @Query(value = "select * from ers_reimbursements r where r.status_id = ?1", nativeQuery = true)
    List<Reimbursement> findReimbursementBystatusId(String statusId);

    @Query(value = "select * from ers_reimbursements r where r.id = ?1", nativeQuery = true)
    Reimbursement findReimbursementByid(String id);


//    updateReimbursementById


}
