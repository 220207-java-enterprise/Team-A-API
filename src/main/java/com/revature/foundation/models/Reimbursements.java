package com.revature.foundation.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ers_reimbursements")
public class Reimbursements { // TODO refactor be singular name

    @Id
    private String id;


    @Column(nullable = false)
    private int amount;
    //TODO change to double

    @Column(nullable = false)
    private Timestamp submitted;

    @Column
    private Timestamp resolved;
//TODO change to local datetime


    @Column(nullable = false)

    private String description;

    @Column
    private String receipt;


    @Column(name = "payment_id")
    private String paymentId;

    @OneToOne(targetEntity = Reimbursements.class)
    @JoinColumn(
            name = "author_id",
            nullable = false
            //columnDefinition = "NUMERIC(6,2)"  explicit type declaration:
    )
    private String authorId;
//TODO make authorID a users Type

    @OneToOne(targetEntity = Reimbursements.class)
    @JoinColumn(name = "resolver_id")

    private String resolverId;
//TODO make resolverId a users Type

    @ManyToOne(targetEntity = Reimbursements.class)
    @JoinColumn(name = "status_id", nullable = false)
    private ReimbursementStatuses statusId;

    @ManyToOne(targetEntity = Reimbursements.class)
    @JoinColumn(name = "type_id", nullable = false)
    private ReimbursementType typeId;


    public Reimbursements() {
        super();
    }

    public Reimbursements(String id, int amount, Timestamp submitted, Timestamp resolved, String description, String receipt, String paymentId, String authorId, String resolverId, ReimbursementStatuses statusId, ReimbursementType typeId) {
        this.id = id;
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

    public Reimbursements(int amount, Timestamp submitted, Timestamp resolved, String description, String receipt, String paymentId, String authorId, String resolverId, ReimbursementStatuses statusId, ReimbursementType typeId) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Reimbursements{" +
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

