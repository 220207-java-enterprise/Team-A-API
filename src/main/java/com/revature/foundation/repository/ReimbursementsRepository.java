package com.revature.foundation.repository;

import com.revature.foundation.models.Reimbursements;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimbursementsRepository extends CrudRepository<Reimbursements, String> {


    @Query(value = "select * from ers_reimbursements r where r.status_id = ?1", nativeQuery = true)
    Reimbursements findReimbursementBystatusId(String statusId);


//    updateReimbursementById


}
