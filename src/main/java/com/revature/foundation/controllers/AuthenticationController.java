package com.revature.foundation.controllers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.DatabindException;
import com.revature.foundation.dtos.requests.LoginRequest;
import com.revature.foundation.dtos.responses.Principal;
import com.revature.foundation.services.TokenService;
import com.revature.foundation.services.UserService;
import com.revature.foundation.util.exceptions.AuthenticationException;
import com.revature.foundation.util.exceptions.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.HashMap;


@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final TokenService tokenService;
    private final UserService userService;

    @Autowired
    public AuthenticationController(TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @CrossOrigin(exposedHeaders = "authorization")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Principal authenticate(@RequestBody LoginRequest request, HttpServletResponse resp) {
        Principal subject = new Principal(userService.login(request));
        resp.setHeader("Authorization", tokenService.generateToken(subject));
        return subject;


        //String token = tokenService.generateToken(subject);
        //resp.setHeader("authorization", token);
        //resp.setStatus(201);

        //System.out.println(subject);
        //return subject;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, Object> handleInvalidRequest(InvalidRequestException e){
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 400);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now());

        return responseBody;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public HashMap<String, Object> handleAuthenticationException(AuthenticationException e){
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 401);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now());

        return responseBody;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HashMap<String, Object> handleAnyOtherException(Exception e){
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 500);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now());

        return responseBody;
    }

}
