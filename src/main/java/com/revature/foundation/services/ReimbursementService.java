package com.revature.foundation.services;

import com.revature.foundation.dtos.requests.AllReimbursementsByIdRequest;
import com.revature.foundation.dtos.requests.NewReimbursementRequest;
import com.revature.foundation.dtos.responses.AppReimbursementResponse;
import com.revature.foundation.dtos.responses.ResourceCreationResponse;
import com.revature.foundation.models.Reimbursement;
import com.revature.foundation.models.ReimbursementStatus;
import com.revature.foundation.repository.ReimbursementsRepository;
import com.revature.foundation.util.exceptions.InvalidRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReimbursementService {

    private final ReimbursementsRepository reimbursementsRepository;

    @Autowired
    public ReimbursementService(ReimbursementsRepository reimbursementsRepository, AllReimbursementsByIdRequest allReimbursementsByIdRequest) {
        this.reimbursementsRepository = reimbursementsRepository;
    }

    public List<AppReimbursementResponse> getAll() {
        List<Reimbursement> reimbursements = (List<Reimbursement>) reimbursementsRepository.findAll();
        List<AppReimbursementResponse> reimbursementResponses = new ArrayList<>();
        for (Reimbursement reimbursement : reimbursements) {
            reimbursementResponses.add(new AppReimbursementResponse(reimbursement));
        }

        return reimbursementResponses;
    }

    @Transactional
    public ResourceCreationResponse create(NewReimbursementRequest newReimbursementRequest) {
        Reimbursement reimbursement = newReimbursementRequest.extractReimbursement();
        reimbursement.setStatusId(new ReimbursementStatus("0", "PENDING"));
        reimbursementsRepository.save(reimbursement);
        return new ResourceCreationResponse(reimbursement.getId());
    }


    public List<Reimbursement> findReimbursementByAuthor_id(String author_id) {
        return reimbursementsRepository.findReimbursementByAuthor_id(author_id);
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
