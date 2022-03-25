package com.revature.foundation.dtos.responses;

import com.revature.foundation.models.Reimbursement;
import com.revature.foundation.models.User;

public class Principal {

    private String userId;
    private String username;
    //private String roleId;
    private String role;

    public Principal() {
        super();
    }

    public Principal(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.role = user.getRole().getRoleName();

    }

    public Principal(Reimbursement reimbursement) {
        this.userId = String.valueOf(reimbursement.getAuthorId());
        this.username = reimbursement.getId();
        this.role = reimbursement.getTypeId().getType();
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


public String getRole() {
    return role;
}

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Principal{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", roleId='" + role + '\'' +
                '}';
    }
}
