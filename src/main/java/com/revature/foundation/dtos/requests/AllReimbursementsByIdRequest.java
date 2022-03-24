package com.revature.foundation.dtos.requests;

import com.revature.foundation.models.ReimbursementStatus;
import com.revature.foundation.models.ReimbursementType;
import com.revature.foundation.models.User;

import java.sql.Timestamp;
import java.util.HashMap;

public class AllReimbursementsByIdRequest {

    private String id;
    private double amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private String receipt;
    private String paymentId;
    private User authorId;
    private User resolverId;
    private ReimbursementStatus statusId;
    private ReimbursementType typeId;

    public AllReimbursementsByIdRequest() {
        super();
    }

    public AllReimbursementsByIdRequest(User authorId) {
        this.authorId = authorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public User extractAuthorId() {
        return this.authorId;
    }

    public AllReimbursementsByIdRequest(HashMap<String, Object> credentials) {
        this.authorId = (User) credentials.get("author_id");
    }

    @Override
    public String toString() {
        return "NewReimbursementRequest{" +
                "id='" + id + '\'' +
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