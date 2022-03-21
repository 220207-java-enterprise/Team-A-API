package com.revature.foundation.dtos.requests;

import com.revature.foundation.models.Reimbursement;
import com.revature.foundation.models.ReimbursementStatus;
import com.revature.foundation.models.ReimbursementType;
import com.revature.foundation.models.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class NewReimbursementRequest {
    private double amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private String receipt;
    //TODO ctr Z
    private String paymentId;
    private User authorId;
    private User resolverId;
    private ReimbursementStatus statusId;
    private ReimbursementType typeId;

    public NewReimbursementRequest() {
        super();
    }

    public NewReimbursementRequest(double amount, Timestamp submitted, Timestamp resolved, String description, String receipt, String paymentId, User authorId, User resolverId, ReimbursementStatus statusId, ReimbursementType typeId) {
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.paymentId = paymentId;
        this.authorId = authorId;
        this.resolverId = resolverId;
        this.statusId = statusId;
        this.typeId = typeId;
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

    public ReimbursementStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(ReimbursementStatus statusId) {
        this.statusId = statusId;
    }

    public ReimbursementType getTypeId() {
        return typeId;
    }

    public void setTypeId(ReimbursementType typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "NewReimbursementRequest{" +
                "amount=" + amount +
                ", submitted='" + submitted + '\'' +
                ", resolved='" + resolved + '\'' +
                ", description='" + description + '\'' +
                ", receipt=" + receipt +
                ", paymentId='" + paymentId + '\'' +
                ", authorId='" + authorId + '\'' +
                ", resolverId='" + resolverId + '\'' +
                ", statusId=" + statusId +
                ", typeId=" + typeId +
                '}';
    }

    public Reimbursement extractReimbursement() {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setId(UUID.randomUUID().toString());
        reimbursement.setAmount(this.amount);
        reimbursement.setSubmitted(Timestamp.valueOf(LocalDateTime.now()));
        reimbursement.setResolved(Timestamp.valueOf(String.valueOf(this.resolved)));
        reimbursement.setDescription(this.description);
        reimbursement.setReceipt(this.receipt);
        reimbursement.setPaymentId(this.paymentId);
        reimbursement.setAuthorId(this.authorId);
        reimbursement.setResolverId(this.resolverId);
        reimbursement.setStatusId(this.statusId);
        reimbursement.setTypeId(this.typeId);
        return reimbursement;
    }
}
