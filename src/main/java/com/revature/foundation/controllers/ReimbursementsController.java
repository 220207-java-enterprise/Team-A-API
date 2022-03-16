package com.revature.foundation.controllers;

import com.revature.foundation.dtos.requests.NewReimbursementRequest;
import com.revature.foundation.dtos.responses.AppReimbursementResponse;
import com.revature.foundation.dtos.responses.ResourceCreationResponse;
import com.revature.foundation.models.Reimbursements;
import com.revature.foundation.repository.ReimbursementsRepository;
import com.revature.foundation.services.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Reimbursements")
public class ReimbursementsController {
    private final ReimbursementsRepository reimbRepo;

    @Autowired
    public ReimbursementsController(ReimbursementsRepository reimbRepo) {
        this.reimbRepo = reimbRepo;
    }
///Will we even have controllers? Do we need this part if not?
    /*@ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = "application/json", consumes = "application/json")
    public List<Reimbursements> getAllReimbursements() {
        List<Reimbursements> reimbursements = (List<Reimbursements>) reimbRepo.findAll();
            return reimbRepo.getAllReimbursements();
        }*/

    }

