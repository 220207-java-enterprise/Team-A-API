package com.revature.foundation.controllers;

import com.fasterxml.jackson.core.JacksonException;
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
public class AuthController {

    private final UserService userService;
    private final TokenService tokenService;

    @Autowired
    public AuthController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @CrossOrigin(exposedHeaders = "authorization")
    @PostMapping(produces = "application/json", consumes = "application/json")
    public Principal login(@RequestBody LoginRequest request, HttpServletResponse response) {
        Principal principal = new Principal(userService.login(request));
        String token = tokenService.generateToken(principal);
        response.setHeader("authorization", token);
        response.setStatus(201);

        System.out.println(principal);
        return principal;
    }

    // TODO centralize exception handlers using an aspect

    @ExceptionHandler(value = {
            InvalidRequestException.class,
            JacksonException.class
    })

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
