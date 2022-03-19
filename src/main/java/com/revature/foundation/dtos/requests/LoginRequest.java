package com.revature.foundation.dtos.requests;

import java.util.HashMap;

public class LoginRequest {

    private String username;
    private String password;

    public LoginRequest() {
        super();
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginRequest(HashMap<String, Object> credentials) {
        this.username = (String) credentials.get("username");
        this.password = (String) credentials.get("password");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
