package com.revature.foundation.controllers;

import com.revature.foundation.dtos.requests.AllReimbursementsByIdRequest;
import com.revature.foundation.dtos.requests.NewReimbursementRequest;
import com.revature.foundation.dtos.responses.AppReimbursementResponse;
import com.revature.foundation.dtos.responses.Principal;
import com.revature.foundation.dtos.responses.ResourceCreationResponse;
import com.revature.foundation.models.Reimbursement;
import com.revature.foundation.models.User;
import com.revature.foundation.services.ReimbursementService;
import com.revature.foundation.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/reimbursements")
public class ReimbursementsController {
    private ReimbursementService reimbursementService;
    private TokenService tokenService;
    private AllReimbursementsByIdRequest allReimbursementsByIdRequest;

    @Autowired
    public ReimbursementsController(ReimbursementService reimbursementService, TokenService tokenService, AllReimbursementsByIdRequest allReimbursementsByIdRequest) {
        this.tokenService = tokenService;
        this.reimbursementService = reimbursementService;
        this.allReimbursementsByIdRequest = allReimbursementsByIdRequest;
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

    @PostMapping(value = "/reimbursement-view-by-author-id", produces = "application/json", consumes = "application/json")
    public List<Reimbursement> findReimbursementByAuthor_id(@RequestBody HashMap<String, Object> authorId, HttpServletResponse resp, HttpServletRequest req) {
        System.out.println(authorId);
        System.out.println(String.valueOf(new AllReimbursementsByIdRequest(authorId)));
        System.out.println("Did I make here?");
        Principal head = tokenService.extractRequesterDetails(String.valueOf(new AllReimbursementsByIdRequest(authorId)));
        System.out.println(head);
        resp.setHeader("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzMjE1IiwiaXNzIjoidGVjaG5vbG9neXAiLCJpYXQiOjE2NDczNzc3NzksImV4cCI6MTY0NzM4MTM3OSwic3ViIjoiR21hbmRlcnIiLCJyb2xlSWQiOiJBZG1pbiJ9.NgV8-UrUGXxuuCJKWBpsXkhyIKMhx82liQgPWBh69EM");
        List<Reimbursement> reimbursements = reimbursementService.findReimbursementByAuthor_id((authorId));
        System.out.println(reimbursements); //TODO this prints last
        return reimbursementService.findReimbursementByAuthor_id(authorId);

    }
}
