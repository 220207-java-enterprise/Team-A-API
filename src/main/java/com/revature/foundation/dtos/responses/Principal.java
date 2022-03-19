package com.revature.foundation.dtos.responses;

import com.revature.foundation.models.Reimbursement;
import com.revature.foundation.models.User;

public class Principal {

    private String userId;
    private String username;
    private String roleId;

    public Principal() {
        super();
    }

    public Principal(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.roleId = user.getRole().getRoleName();
    }

    public Principal(Reimbursement reimbursement) {
        this.userId = String.valueOf(reimbursement.getAuthorId());
        this.username = reimbursement.getId();
        this.roleId = reimbursement.getTypeId().getType();
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Principal{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
