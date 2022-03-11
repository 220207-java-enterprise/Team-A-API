package com.revature.foundation.repository;

import com.revature.foundation.models.Reimbursements;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimbursementsRepository extends CrudRepository<Reimbursements, String> {

//    List<Reimbursements> getReimbursementsByUID(String reimbId);

    @Query("from Reimbursements r where r.reimbId = ?1")
    List<Reimbursements> getReimbursementsByUID(String reimbId);

    @Query(
            value = "SELECT * from ers_reimbursements where status_id is ?1",
            nativeQuery = true
    )
    List<Reimbursements> findReimbursementsByStatus(String statusId);

    @Query(
            value = "SELECT * from ers_reimbursements",
            nativeQuery = true
    )
    List<Reimbursements> getAllReimbursements();

    @Override //When I delete this it doesn't break it? IDK why.
    @Query(
            value = "INSERT INTO ers_reimbursements VALUES (?, ?, ?, ?, ?, null, ?, ?, ?, ?, ?)",
            nativeQuery = true
    )
    Reimbursements save(Reimbursements newObject);

//This is the variant that doesn't have yellow warning
    @Query(
            value = "INSERT INTO ers_reimbursements VALUES (?, ?, ?, ?, ?, null, ?, ?, ?, ?, ?)",
            nativeQuery = true
    )
    String save(String newObject);




}
