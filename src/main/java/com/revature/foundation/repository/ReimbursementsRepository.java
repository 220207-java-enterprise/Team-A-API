package com.revature.foundation.repository;

import com.revature.foundation.models.Reimbursement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimbursementsRepository extends CrudRepository<Reimbursement, String> {


    @Query(value = "select * " +
                   "from ers_reimbursements r " +
                   "join ers_reimbursement_statuses s " +
                   "on r.status_id = s.id " +
                   "where s.status = ?1", nativeQuery = true)
    List<Reimbursement> findReimbursementByStatus(String status);

    @Query(value = "select * from ers_reimbursements r where r.author_id = ?1", nativeQuery = true)
    List<Reimbursement> findReimbursementByauthor_id(String author_id);


//    updateReimbursementById


}
