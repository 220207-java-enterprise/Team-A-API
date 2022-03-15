package com.revature.foundation.controllers;

import com.revature.foundation.dtos.requests.LoginRequest;
import com.revature.foundation.dtos.requests.NewUserRequest;
import com.revature.foundation.dtos.responses.Principal;
import com.revature.foundation.dtos.responses.ResourceCreationResponse;
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

    private UserService userService;
    @Autowired
    public UsersController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResourceCreationResponse registerUser(@RequestBody NewUserRequest request) {
        return userService.register(request);
    }

    // Using an injected HttpServletResponse to modify response headers/status code
    // Login
    @PostMapping(value = "login", produces = "application/json", consumes = "application/json")
    public void login(@RequestBody HashMap<String, Object> credentials, HttpServletResponse resp) {
        //    public void login(@RequestBody String username, String password, HttpServletResponse resp) {
//pass as request instead of hashmap

            System.out.println("this");
            LoginRequest loginRequest = new LoginRequest(credentials);
            System.out.println(loginRequest);
            Principal principal = new Principal(userService.login(loginRequest));
            System.out.println(principal);

            String token = tokenService.generateToken(principal);
            resp.setHeader("Authorization", token);

    }
//        if (credentials.get("username").equals("Gmanderr") && credentials.get("password").equals("p@$$w0rD")) {
//        System.out.println("this");
//        LoginRequest loginRequest = new LoginRequest(credentials);
//        System.out.println(loginRequest);
//        String token = tokenService.generateToken(loginRequest);
//            resp.setHeader("Authorization", token);
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
