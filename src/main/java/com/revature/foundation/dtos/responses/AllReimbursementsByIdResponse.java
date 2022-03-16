package com.revature.foundation.dtos.responses;

import com.revature.foundation.models.Reimbursements;
import com.revature.foundation.models.User;

import java.sql.Timestamp;
import java.util.List;

public class AllReimbursementsByIdResponse {

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

    public AllReimbursementsByIdResponse() {
    }

//    public AllReimbursementsByIdResponse(String authorId) {
//        Reimbursements reimbursements = new Reimbursements().getAuthorId();
//        this.reimbId = reimbursements.getReimbId();
//        this.amount = reimbursements.getAmount();
//        this.submitted = reimbursements.getSubmitted();
//        this.resolved = reimbursements.getResolved();
//        this.description = reimbursements.getDescription();
//        this.receipt = reimbursements.getReceipt();
//        this.paymentId = reimbursements.getPaymentId();
//        this.authorId = reimbursements.getAuthorId();
//        this.resolverId = reimbursements.getResolverId();
//        this.statusId = reimbursements.getStatusId().getStatus();
//        this.typeId = reimbursements.getTypeId().getType();
//    }

    public AllReimbursementsByIdResponse(List<Reimbursements> allReimbursementsById) {
        for(Reimbursements reimbursements : allReimbursementsById) {
            this.reimbId = reimbursements.getId();
            this.amount = reimbursements.getAmount();
            this.submitted = reimbursements.getSubmitted();
            this.resolved = reimbursements.getResolved();
            this.description = reimbursements.getDescription();
            this.receipt = reimbursements.getReceipt();
            this.paymentId = reimbursements.getPaymentId();
            this.authorId = reimbursements.getAuthorId();
            this.resolverId = reimbursements.getResolverId();
            this.statusId = reimbursements.getStatusId().getStatus();
            this.typeId = reimbursements.getTypeId().getType();

        }
//        return allReimbursementsById;
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
