package com.revature.foundation.repository;

import com.revature.foundation.models.Reimbursements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReimbursementsRepository extends JpaRepository<Reimbursements, String> {

    List<Reimbursements> getAll();

    @Query("from ers_reimbursements r where r.id = ?1")
    Reimbursements getById(String id);

    @Query("from ers_reimbursements r where r.id = ?1")
    Reimbursements getAllById(String id);

    @Query("from ers_reimbursements r where r.author_id = ?1")
    List<Reimbursements> getByAuthorId(String author_id);

    @Transactional
    @Query(value = "UPDATE ers_reimbursements " + "SET description = ?1, "+ "amount = ?2 "+ "WHERE reimb_id = ?3", nativeQuery = true)
    void update(String description, double amount, String reimb_id);

    @Query("from ers_reimbursements r where r.id = ?1")
    void deleteById(String id);



//    List<Reimbursements> findReimbursementBystatusId(String statusId);



}
