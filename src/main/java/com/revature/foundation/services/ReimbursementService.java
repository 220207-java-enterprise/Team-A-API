package com.revature.foundation.services;


import com.revature.foundation.dtos.requests.NewReimbursementRequest;
import com.revature.foundation.dtos.responses.AppReimbursementResponse;
import com.revature.foundation.dtos.responses.ResourceCreationResponse;
import com.revature.foundation.models.Reimbursement;
import com.revature.foundation.repository.ReimbursementsRepository;
import com.revature.foundation.repository.UsersRepository;
import com.revature.foundation.util.exceptions.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReimbursementService {

    private final ReimbursementsRepository reimbursementsRepository;

    @Autowired
    public ReimbursementService(ReimbursementsRepository reimbursementsRepository) {
        this.reimbursementsRepository = reimbursementsRepository;
    }

    public List<Reimbursement> getAll() {
        List<Reimbursement> reimbursements = (List<Reimbursement>) reimbursementsRepository.findAll();
        List<AppReimbursementResponse> reimbursementResponses = new ArrayList<>();
        for (Reimbursement reimbursement : reimbursements) {
            reimbursementResponses.add(new AppReimbursementResponse(reimbursement));
        }

        return reimbursements;
    }

    public ResourceCreationResponse create(NewReimbursementRequest newReimbursementRequest) {

        Reimbursement reimbursement = newReimbursementRequest.extractReimbursement();

        reimbursementsRepository.save(reimbursement);
        //Should this implement public abstract save instead of overriden save in Repo?

        return new ResourceCreationResponse(reimbursement.getId());




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
    // commented out until it gets rewritten without DAO
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

//    public List<Reimbursements> getAllReimbursementsById(AllReimbursementsByIdRequest allReimbursementsByIdRequest) throws SQLException {
////        System.out.println("somethings");
//
//        User authorId = allReimbursementsByIdRequest.getAuthorId();
////        System.out.println(authorId);
//
//        List<Reimbursements>  reimbursements = reimbursementsRepository.findReimbursementBystatusId(authorId.getUserId());
//        System.out.println("something here" + reimbursements + "asodf");
//        if (reimbursements == null) {
//            throw new AuthenticationException();
//        }
//
//        return reimbursements;
//
//    }

    public List<Reimbursement> findReimbursementByauthor_id(String author_id) {
        System.out.println("asfadf " + author_id);
        System.out.println(reimbursementsRepository.findReimbursementByauthor_id(author_id));
        System.out.println("last print");
        List<Reimbursement> authorsReimbursements = reimbursementsRepository.findReimbursementByauthor_id(author_id);
        System.out.println("something" + authorsReimbursements);
        return authorsReimbursements;

    }

    @Transactional
    public List<AppReimbursementResponse> findReimbursementsByStatus(String status) {

        if (status == null) {
            throw new InvalidRequestException("Null status name provided!");
        }

        switch (status.toUpperCase()) {
            case "PENDING":
            case "APPROVED":
            case "DENIED":
                break;
            default:
                throw new InvalidRequestException("Invalid status name provided!");
        }

        return reimbursementsRepository.findReimbursementByStatus(status.toUpperCase())
                .stream()
                .map(AppReimbursementResponse::new)
                .collect(Collectors.toList());
    }

}
