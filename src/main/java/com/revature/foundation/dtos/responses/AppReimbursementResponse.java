package com.revature.foundation.dtos.responses;

import com.revature.foundation.models.ReimbursementStatuses;
import com.revature.foundation.models.ReimbursementType;
import com.revature.foundation.models.Reimbursements;

import java.sql.Timestamp;

public class AppReimbursementResponse {
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
    private ReimbursementStatuses statusId;
    private ReimbursementType typeId;

    public AppReimbursementResponse() {
        super();
    }

    public AppReimbursementResponse(Reimbursements reimbursements) {
        this.reimbId = reimbursements.getId();
        this.amount = reimbursements.getAmount();
        this.submitted = reimbursements.getSubmitted();
        this.resolved = reimbursements.getResolved();
        this.description = reimbursements.getDescription();
        this.receipt = reimbursements.getReceipt();
        this.paymentId = reimbursements.getPaymentId();
        this.authorId = reimbursements.getAuthorId();
        this.resolverId = reimbursements.getResolverId();
        this.statusId = reimbursements.getStatusId();
        this.typeId = reimbursements.getTypeId();
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

    public ReimbursementStatuses getStatusId() {
        return statusId;
    }

    public void setStatusId(ReimbursementStatuses statusId) {
        this.statusId = statusId;
    }

    public ReimbursementType getTypeId() {
        return typeId;
    }

    public void setTypeId(ReimbursementType typeId) {
        this.typeId = typeId;
    }
}
