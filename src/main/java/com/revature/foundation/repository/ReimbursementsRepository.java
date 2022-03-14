package com.revature.foundation.repository;

import com.revature.foundation.models.Reimbursements;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimbursementsRepository extends CrudRepository<Reimbursements, String> {



    List<Reimbursements> findReimbursementBystatusId(String statusId);





}
