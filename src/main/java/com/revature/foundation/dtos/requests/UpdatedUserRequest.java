package com.revature.foundation.dtos.requests;

import com.revature.foundation.models.UserRole;
import com.revature.foundation.models.User;
import com.revature.foundation.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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

    // Constructor injection
    //If you only have one constructor then you dont really need this autowired tag ebcause its implied
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


    //TODO un-DOA-afy this when we update a user
//    public User extractUser() {
////        UsersDAO daoToPullUserForRole_Id = new UsersDAO();
////        Users pulledUser = daoToPullUserForRole_Id.getById(this.userId);
//////        Users pulledUser = otherVar.getById(this.role);
////        UserRole aRole = new UserRole(pulledUser.getRole().getId(), role);
////        System.out.println("tsate" + pulledUser);
////        return pulledUser;
//
//
//        User pulledUser = usersRepository.findById(this.userId);
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
