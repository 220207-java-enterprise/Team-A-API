package com.revature.foundation.models;

import javax.persistence.*;

@Entity
@Table(name = "ers_reimbursements")
public class Reimbursements { // TODO refactor be singular name
    @Id
    private String reimbId;

    @Column(nullable = false)
    private int amount;
    //TODO change to double

    @Column(nullable = false)
    private String submitted;
//TODO change to local datetime
    @Column
    private String resolved;
//TODO change to local datetime

    @Column(nullable = false)
    private String description;

    @Lob
    @Column
    private byte[] receipt;

    @Column(name = "payment_id")
    private String paymentId;

    @Column(
            name = "author_id",
            nullable = false
            //columnDefinition = "NUMERIC(6,2)"  explicit type declaration:
    )
    private String authorId;
//TODO make authorID a users Type and instead of a column make this a join column

    @Column(name = "resolver_id")
    private String resolverId;
//TODO make resolverId a users Type and instead of a column make this a join column

    @Embedded // TODO specifiy multiplcity (many-to-one)
    private ReimbursementStatuses statusId;
//TODO make statusId instead of a column make this a join column

    @Embedded // TODO specifiy multiplcity (many-to-one)
    private ReimbursementType typeId;
//TODO make typeId instead of a column make this a join column


    public Reimbursements() {
        super();
    }

    public Reimbursements(String reimbId, int amount, String submitted, String resolved, String description, byte[] receipt, String paymentId, String authorId, String resolverId, ReimbursementStatuses statusId, ReimbursementType typeId) {
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

    public Reimbursements(int amount, String submitted, String resolved, String description, byte[] receipt, String paymentId, String authorId, String resolverId, ReimbursementStatuses statusId, ReimbursementType typeId) {
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