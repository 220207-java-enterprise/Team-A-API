package com.revature.foundation.dtos.requests;

import com.revature.foundation.models.ReimbursementStatuses;
import com.revature.foundation.models.ReimbursementType;
import com.revature.foundation.models.Reimbursements;

import java.time.LocalDateTime;
import java.util.UUID;

public class NewReimbursementRequest {
    private int amount;
    private String submitted;
    private String resolved;
    private String description;
    private byte[] receipt;
    //TODO ctr Z
    private String paymentId;
    private String authorId;
    private String resolverId;
    private ReimbursementStatuses statusId;
    private ReimbursementType typeId;

    public NewReimbursementRequest() {
        super();
    }

    public NewReimbursementRequest(int amount, String submitted, String resolved, String description, byte[] receipt, String paymentId, String authorId, String resolverId, ReimbursementStatuses statusId, ReimbursementType typeId) {
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

    public Reimbursements extractReimbursement() {
        Reimbursements reimbursements = new Reimbursements();
        reimbursements.setReimbId(UUID.randomUUID().toString());
        reimbursements.setAmount(this.amount);
        reimbursements.setSubmitted(String.valueOf(LocalDateTime.now()));
        reimbursements.setResolved(this.resolved);
        reimbursements.setDescription(this.description);
        reimbursements.setReceipt(this.receipt);
        reimbursements.setPaymentId(this.paymentId);
        reimbursements.setAuthorId(this.authorId);
        reimbursements.setResolverId(this.resolverId);
        reimbursements.setStatusId(this.statusId);
        reimbursements.setTypeId(this.typeId);
        return reimbursements;
    }
}
