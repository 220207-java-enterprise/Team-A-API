package com.revature.foundation.controllers;

import com.revature.foundation.dtos.requests.NewReimbursementRequest;
import com.revature.foundation.dtos.responses.AppReimbursementResponse;
import com.revature.foundation.dtos.responses.ResourceCreationResponse;
import com.revature.foundation.services.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reimbursements")
public class ReimbursementsController {
    private ReimbursementService reimbursementService;

    @Autowired
    public ReimbursementsController(ReimbursementService reimbursementService) {
        this.reimbursementService = reimbursementService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResourceCreationResponse createReimbursement(@RequestBody NewReimbursementRequest request) {
        return reimbursementService.create(request);
    }

    @GetMapping(value = "/{status}")
    public List<AppReimbursementResponse> getReimbursementsByStatus(@PathVariable String status) {
        return reimbursementService.findReimbursementsByStatus(status);
    }

}
