package com.revature.foundation.dtos.responses;

import com.revature.foundation.models.Reimbursements;
import com.revature.foundation.util.Bytea;

import java.util.List;

public class AllReimbursementsByIdResponse {

    private String reimbId;
    private int amount;
    private String submitted;
    private String resolved;
    private String description;
    private byte[] receipt;
    //TODO ctrz
    private String paymentId;
    private String authorId;
    private String resolverId;
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
            this.reimbId = reimbursements.getReimbId();
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    public String getResolved() {
        return resolved;
    }

    public void setResolved(String resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getReceipt() {
        return receipt;
    }

    public void setReceipt(byte[] receipt) {
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
