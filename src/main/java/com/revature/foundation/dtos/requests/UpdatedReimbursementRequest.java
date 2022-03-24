package com.revature.foundation.dtos.requests;

public class UpdatedReimbursementRequest {

    private String reimbId;
    private double amount;
    private String description;
    private String type;
    private String status;
    private String resolverId;

    public String getReimbId() {
        return reimbId;
    }

    public void setReimbId(String reimbId) {
        this.reimbId = reimbId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResolverId() {
        return resolverId;
    }

    public void setResolverId(String resolverId) {
        this.resolverId = resolverId;
    }

    @Override
    public String toString() {
        return "UpdatedReimbursementRequest{" +
                "reimbId='" + reimbId + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", resolverId='" + resolverId + '\'' +
                '}';
    }

}
