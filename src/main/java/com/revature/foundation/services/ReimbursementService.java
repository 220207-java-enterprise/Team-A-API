package com.revature.foundation.services;

import com.revature.foundation.daos.ReimbursementsDAO;
import com.revature.foundation.dtos.requests.AllReimbursementsByIdRequest;
import com.revature.foundation.dtos.requests.NewReimbursementRequest;
import com.revature.foundation.dtos.responses.AppReimbursementResponse;
import com.revature.foundation.dtos.responses.ResourceCreationResponse;
import com.revature.foundation.models.Reimbursements;
import com.revature.foundation.repository.ReimbursementsRepository;
import com.revature.foundation.repository.UsersRepository;
import com.revature.foundation.util.exceptions.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReimbursementService {
//OLD    private ReimbursementsDAO reimbursementsDAO; // a dependency of UserService
    private ReimbursementsRepository reimbursementsRepository;
    // Constructor injection

    @Autowired
    public ReimbursementService(ReimbursementsRepository reimbursementsRepository) {
        this.reimbursementsRepository = reimbursementsRepository;
    }




    private UsersRepository usersRepository;
//OLD    private UsersDAO userDAO;
    public List<Reimbursements> getAll() {
        List<Reimbursements> reimbursements = (List<Reimbursements>) reimbursementsRepository.findAll();
        List<AppReimbursementResponse> reimbursementResponses = new ArrayList<>();
        for (Reimbursements reimbursement : reimbursements) {
            reimbursementResponses.add(new AppReimbursementResponse(reimbursement));
        }

        return reimbursements;
    }

    public ResourceCreationResponse create(NewReimbursementRequest newReimbursementRequest) {

        Reimbursements reimbursements = newReimbursementRequest.extractReimbursement();

        reimbursementsRepository.save(reimbursements);
        //Should this implement public abstract save instead of overriden save in Repo?

        return new ResourceCreationResponse(reimbursements.getId());




// Old version that used DAO's
//        Reimbursements newReimbursement = newReimbursementRequest.extractReimbursement();
//        System.out.println("pointer" + newReimbursement.toString());
//
//        //TODO add if reimbursementIsValid logic
//        ReimbursementStatuses sdf = new ReimbursementStatuses("0", "PENDING");
//        newReimbursement.setReimbId(UUID.randomUUID().toString());
//        newReimbursement.setStatusId(sdf);
//        reimbursementsDAO.save(newReimbursement);
//
//        return newReimbursement;

    }

    //redundant?
    // commented out until it gets rewrited without DAO
//    public Reimbursements updatedReimbursement(UpdatedReimbursementRequest updateRequest) {
//        Reimbursements updatedReimbursement = updateRequest.extractReimbursement();
//
//        reimbursementsDAO.update(updatedReimbursement);
//        return updatedReimbursement;
//    }
//
//    public String AllReimbursementsById(AllReimbursementsByIdRequest allReimbursementsByIdRequest) throws SQLException {
//        String allReimbursements = allReimbursementsByIdRequest.extractAuthorid();
//
//        reimbursementsDAO.getAllById(allReimbursements);
//
//        return allReimbursements;
//    }

    public List<Reimbursements> getAllReimbursementsById(AllReimbursementsByIdRequest allReimbursementsByIdRequest) throws SQLException {
//        System.out.println("somethings");

        String authorId = allReimbursementsByIdRequest.getAuthorId();
//        System.out.println(authorId);

        List<Reimbursements>  reimbursements = ReimbursementsDAO.getAllById(authorId);
        System.out.println("something here" + reimbursements + "asodf");
        if (reimbursements == null) {
            throw new AuthenticationException();
        }

        return reimbursements;

    }

    public Reimbursements updateReimbursementById(String id) {
        System.out.println("asfadf " + id);
        System.out.println(reimbursementsRepository.findReimbursementBystatusId(id));
        System.out.println("last print");
        Reimbursements updatingThisReimbursement = reimbursementsRepository.findReimbursementBystatusId(id);
        System.out.println(updatingThisReimbursement);
        return null;

    }

}
