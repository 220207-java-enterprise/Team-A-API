package com.revature.foundation.dtos.responses;

import com.revature.foundation.models.Reimbursements;

import java.sql.Timestamp;

public class UpdatedReimbursementResponse {

    private String reimbId;
    private int amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private String receipt;
    //TODO ctrz
    private String paymentId;
    private String authorId;
    private String resolverId;
    private String statusId;
    private String typeId;

    public UpdatedReimbursementResponse() {
    }

    public UpdatedReimbursementResponse(Reimbursements reimbursements) {
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

    public String getReimbId() {
        return reimbId;
    }

    public void setReimbId(String reimbId) {
        this.reimbId = reimbId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getResolverId() {
        return resolverId;
    }

    public void setResolverId(String resolverId) {
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
