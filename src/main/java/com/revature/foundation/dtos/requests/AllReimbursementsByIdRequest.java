package com.revature.foundation.dtos.requests;

import com.revature.foundation.daos.ReimbursementsDAO;
import com.revature.foundation.models.ReimbursementStatuses;
import com.revature.foundation.models.ReimbursementType;
import com.revature.foundation.models.Reimbursements;

import java.sql.Timestamp;

public class AllReimbursementsByIdRequest {

    private String reimbId;
    private int amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private String receipt;
    //TODO ctr + z
    private String paymentId;
    private String authorId;
    private String resolverId;
    private String statusId;
    private String typeId;

    public AllReimbursementsByIdRequest() {
        super();
    }

    public AllReimbursementsByIdRequest(String authorId) {
        this.authorId = authorId;
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

    public Reimbursements extractReimbursement() {

        ReimbursementsDAO daoToPullUserForRole_Id = new ReimbursementsDAO();
        Reimbursements pulledReimbursement = daoToPullUserForRole_Id.getById(this.reimbId);

        ReimbursementStatuses aStatus = new ReimbursementStatuses(pulledReimbursement.getStatusId().getStatus(), statusId);
        ReimbursementType aType = new ReimbursementType(pulledReimbursement.getTypeId().getType(), statusId);
        return new Reimbursements(this.reimbId, this.amount, this.submitted, this.resolved, this.description, this.receipt, this.paymentId, this.authorId, this.resolverId, aStatus, aType);
    }

    public String extractAuthorid() {
        return this.authorId;
    }

    @Override
    public String toString() {
        return "NewReimbursementRequest{" +
                "reimbId='" + reimbId + '\'' +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", receipt=" + receipt +
                ", paymentId='" + paymentId + '\'' +
                ", authorId='" + authorId + '\'' +
                ", resolverId='" + resolverId + '\'' +
                ", statusId='" + statusId + '\'' +
                ", typeId='" + typeId + '\'' +
                '}';
    }
}