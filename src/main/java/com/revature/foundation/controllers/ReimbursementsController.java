package com.revature.foundation.controllers;

import com.revature.foundation.dtos.requests.NewReimbursementRequest;
import com.revature.foundation.dtos.responses.AppReimbursementResponse;
import com.revature.foundation.dtos.responses.Principal;
import com.revature.foundation.dtos.responses.ResourceCreationResponse;
import com.revature.foundation.models.Reimbursement;
import com.revature.foundation.services.ReimbursementService;
import com.revature.foundation.services.TokenService;
import com.revature.foundation.util.exceptions.AuthenticationException;
import com.revature.foundation.util.exceptions.AuthorizationException;
import com.revature.foundation.util.exceptions.InvalidRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/reimbursements")
public class ReimbursementsController {

    private ReimbursementService reimbursementService;
    private TokenService tokenService;

    @Autowired
    public ReimbursementsController(ReimbursementService reimbursementService, TokenService tokenService) {
        this.reimbursementService = reimbursementService;
        this.tokenService = tokenService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResourceCreationResponse createReimbursement(@RequestHeader("Authorization") String token, @RequestBody NewReimbursementRequest request) {
        Principal requester = tokenService.extractRequesterDetails(token);
        if (requester == null) {
            throw new AuthenticationException();
        }

        if (!requester.getRole().equalsIgnoreCase("EMPLOYEE")) {
            throw new AuthorizationException();
        }

        request.setAuthorId(requester.getUserId());
        return reimbursementService.create(request);
    }

    @GetMapping(value = "/{status}")
    public List<AppReimbursementResponse> getReimbursementsByStatus(@PathVariable String status) {
        return reimbursementService.findReimbursementsByStatus(status);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, Object> handleInvalidRequests(InvalidRequestException e) {
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 400);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now());
        return responseBody;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public HashMap<String, Object> handleAuthenticationException(AuthenticationException e) {
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 401);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now());
        return responseBody;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public HashMap<String, Object> handleAuthorizationException(AuthorizationException e) {
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 403);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now());
        return responseBody;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(produces = "application/json", consumes = "application/json")
    public void updateReimbursementById(@RequestBody HashMap<String, Object> updatedReimbursement, HttpServletResponse resp) {
        reimbursementService.findReimbursementByAuthor_id("123");
    }

    // TODO implement me
    @GetMapping(produces = "application/json")
    public List<Reimbursement> findReimbursementByAuthorId(@RequestParam String authorId, @RequestHeader("Authorization") String token) {
        return null;
    }

}

