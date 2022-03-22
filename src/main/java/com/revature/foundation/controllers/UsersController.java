package com.revature.foundation.controllers;

import com.revature.foundation.dtos.requests.LoginRequest;
import com.revature.foundation.dtos.requests.NewUserRequest;
import com.revature.foundation.dtos.responses.Principal;
import com.revature.foundation.dtos.responses.ResourceCreationResponse;
import com.revature.foundation.repository.ReimbursementsRepository;
import com.revature.foundation.services.ReimbursementService;
import com.revature.foundation.services.TokenService;
import com.revature.foundation.services.UserService;
import com.revature.foundation.util.exceptions.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.HashMap;


@RestController
@RequestMapping("/users")
public class UsersController {

    private TokenService tokenService;
    //private ReimbursementService reimbursementService;
    private UserService userService;
    @Autowired
    public UsersController(UserService userService, TokenService tokenService, ReimbursementService reimbursementService) {
        this.userService = userService;
        this.tokenService = tokenService;
        //this.reimbursementService = reimbursementService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResourceCreationResponse registerUser(@RequestBody NewUserRequest request) {
        return userService.register(request);
    }

    @PostMapping(value = "register", produces = "application/json", consumes = "application/json")
    public void register(@RequestBody HashMap<String, Object> credentials, HttpServletResponse resp) {

        NewUserRequest newUserRequest = new NewUserRequest(credentials);
        userService.register(newUserRequest);
        Principal principal = new Principal(userService.login(newUserRequest));
        String token = tokenService.generateToken(principal);
        resp.setHeader("Authorization", token);
    }

    // Using an injected HttpServletResponse to modify response headers/status code
    // Login
    @PostMapping(value = "login", produces = "application/json", consumes = "application/json")
    public void login(@RequestBody HashMap<String, Object> credentials, HttpServletResponse resp) {
        //    public void login(@RequestBody String username, String password, HttpServletResponse resp) {
//pass as request instead of hashmap

            LoginRequest loginRequest = new LoginRequest(credentials);
            Principal principal = new Principal(userService.login(loginRequest));
            String token = tokenService.generateToken(principal);
            resp.setHeader("Authorization", token);

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

}
