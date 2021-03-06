package com.revature.foundation.dtos.responses;

import com.revature.foundation.models.Reimbursement;
import com.revature.foundation.models.User;

import java.sql.Timestamp;

public class UpdatedReimbursementResponse {

    private String reimbId;
    private double amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private String receipt;
    //TODO ctrz
    private String paymentId;
    private User authorId;
    private User resolverId;
    private String statusId;
    private String typeId;

    public UpdatedReimbursementResponse() {
    }

    public UpdatedReimbursementResponse(Reimbursement reimbursement) {
        this.reimbId = reimbursement.getId();
        this.amount = reimbursement.getAmount();
        this.submitted = reimbursement.getSubmitted();
        this.resolved = reimbursement.getResolved();
        this.description = reimbursement.getDescription();
        this.receipt = reimbursement.getReceipt();
        this.paymentId = reimbursement.getPaymentId();
        this.authorId = reimbursement.getAuthorId();
        this.resolverId = reimbursement.getResolverId();
        this.statusId = reimbursement.getStatusId().getStatus();
        this.typeId = reimbursement.getTypeId().getType();
    }

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

    public Timestamp getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public User getAuthorId() {
        return authorId;
    }

    public void setAuthorId(User authorId) {
        this.authorId = authorId;
    }

    public User getResolverId() {
        return resolverId;
    }

    public void setResolverId(User resolverId) {
        this.resolverId = resolverId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
