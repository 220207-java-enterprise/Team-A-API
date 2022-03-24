package com.revature.foundation.dtos.requests;

import com.revature.foundation.models.User;
import com.revature.foundation.models.UserRole;
import com.revature.foundation.util.Security;


import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;

public class NewUserRequest {

    private String givenName;
    private String surname;
    private String email;
    private String username;
    private String password;

    public NewUserRequest() {
        super();
    }

    public NewUserRequest(String givenName, String surname, String email, String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = Security.generateStrongPasswordHash(password);
    }


    public NewUserRequest(HashMap<String, Object> credentials) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.username = (String) credentials.get("username");
        this.email = (String) credentials.get("email");
        String encryptedPassword = Security.generateStrongPasswordHash((String) credentials.get("password"));
        this.password = encryptedPassword;
        this.givenName = (String) credentials.get("given_name");
        this.surname = (String) credentials.get("surname");
    }



    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "NewUserRequest{" +
                "givenName='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User extractUser() {
        User userData=new User();
        userData.setGivenName(givenName);
        userData.setSurname(surname);
        userData.setEmail(email);
        userData.setUsername(username);
        userData.setPassword(password);


        return userData;
    }
}
