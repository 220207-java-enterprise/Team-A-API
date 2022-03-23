package com.revature.foundation.dtos.requests;

import com.revature.foundation.models.UserRole;
import com.revature.foundation.models.User;
import com.revature.foundation.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UpdatedUserRequest {
    private String userId;
    private String username;
    private String email;
    private String password;
    private String givenName;
    private String surname;
    private Boolean isActive;
    private String role;


    private UsersRepository usersRepository;

   @Autowired
    public UpdatedUserRequest(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public UpdatedUserRequest() {
        super();
    }

    public UpdatedUserRequest(String userId, String username, String email, String password, String givenName, String surname, Boolean isActive, String role) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.givenName = givenName;
        this.surname = surname;
        this.isActive = isActive;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//OG, prob uncomment eventually
//    public User extractUser(HashMap<String, Object> credentials) {
//        User pulledUser = usersRepository.findById(this.userId).orElse(null);
//        assert pulledUser != null;
//        UserRole aRole = new UserRole(pulledUser.getRole().getId(), role);
//        return new User(this.userId, this.username, this.email, this.password, this.givenName, this.surname, this.isActive, aRole);
//    }

    public User extractUser(HashMap<String, Object> credentials) {
       this.userId = (String) credentials.get("userId");
        this.username = (String) credentials.get("username");
        this.email = (String) credentials.get("email");
        this.givenName = (String) credentials.get("givenName");
        this.surname = (String) credentials.get("surname");
        this.isActive = (Boolean) credentials.get("isActive");
        this.role = (String) credentials.get("role");


        User pulledUser = usersRepository.findById(this.userId).orElse(null);
        assert pulledUser != null;
        UserRole aRole = new UserRole(pulledUser.getRole().getId(), role);
        return(new User());
        //TODO un comment below
//        return new User(this.userId, this.username, this.email, this.password, this.givenName, this.surname, this.isActive, this.role);
    }

//    public HashMap<String, Object> extractUser() {
//        User pulledUser = usersRepository.findById(this.userId).orElse(null);
//        assert pulledUser != null;
//        UserRole aRole = new UserRole(pulledUser.getRole().getId(), role);
//        return new User(this.userId, this.username, this.email, this.password, this.givenName, this.surname, this.isActive, aRole);
//    }

    @Override
    public String toString() {
        return "UpdatedUserRequest{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", givenName='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", isActive='" + isActive + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
