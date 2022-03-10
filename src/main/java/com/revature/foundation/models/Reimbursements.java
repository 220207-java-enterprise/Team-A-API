package com.revature.foundation.models;

import com.revature.foundation.util.Bytea;

import javax.persistence.*;

@Entity
@Table(name = "reimbursements")
public class Reimbursements {
    @Id
    private String reimbId;

    @Column
    private int amount;

    @Column
    private String submitted;

    @Column
    private String resolved;

    @Column
    private String description;

    @Column
    private Bytea receipt;

    @Column
    private String paymentId;

    @Column
    private String authorId;

    @Column
    private String resolverId;

    @Embedded
    private ReimbursementStatuses statusId;

    @Embedded
    private ReimbursementTypes typeId;

    public Reimbursements() {
        super();
    }

    public Reimbursements(String reimbId, int amount, String submitted, String resolved, String description, Bytea receipt, String paymentId, String authorId, String resolverId, ReimbursementStatuses statusId, ReimbursementTypes typeId) {
        this.reimbId = reimbId;
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

    public Reimbursements(int amount, String submitted, String resolved, String description, Bytea receipt, String paymentId, String authorId, String resolverId, ReimbursementStatuses statusId, ReimbursementTypes typeId) {
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

    public Bytea getReceipt() {
        return receipt;
    }

    public void setReceipt(Bytea receipt) {
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

    public ReimbursementTypes getTypeId() {
        return typeId;
    }

    public void setTypeId(ReimbursementTypes typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Reimbursements{" +
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
