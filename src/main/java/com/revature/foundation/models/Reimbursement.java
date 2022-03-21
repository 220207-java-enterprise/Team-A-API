package com.revature.foundation.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ers_reimbursements")
public class Reimbursement {

    @Id
    private String id;


    @Column(name = "amount", nullable = false, columnDefinition = "numeric(6,2)")
    private double amount;

    @Column(nullable = false)
    private Timestamp submitted;

    @Column
    private Timestamp resolved;


    @Column(nullable = false)
    private String description;

    @Column
    private String receipt;

    @Column(name = "payment_id")
    private String paymentId;

    @ManyToOne(targetEntity = Reimbursement.class)
    @JoinColumn(
            name = "author_id",
            nullable = false
            //columnDefinition = "NUMERIC(6,2)"  explicit type declaration:
    )
    private User authorId;


    @OneToOne(targetEntity = Reimbursement.class)
    @JoinColumn(name = "resolver_id")
    private User resolverId;


    @ManyToOne(targetEntity = Reimbursement.class)
    @JoinColumn(name = "status_id", nullable = false)
    private ReimbursementStatuses statusId;

    @ManyToOne(targetEntity = Reimbursement.class)
    @JoinColumn(name = "type_id", nullable = false)
    private ReimbursementType typeId;


    public Reimbursement() {
        super();
    }

    public Reimbursement(String id, double amount, Timestamp submitted, Timestamp resolved, String description, String receipt, String paymentId, User authorId, User resolverId, ReimbursementStatuses statusId, ReimbursementType typeId) {
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

    public Reimbursement(double amount, Timestamp submitted, Timestamp resolved, String description, String receipt, String paymentId, User authorId, User resolverId, ReimbursementStatuses statusId, ReimbursementType typeId) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reimbursement)) return false;
        Reimbursement that = (Reimbursement) o;
        return Double.compare(that.amount, amount) == 0
                && Objects.equals(id, that.id)
                && Objects.equals(submitted, that.submitted)
                && Objects.equals(resolved, that.resolved)
                && Objects.equals(description, that.description)
                && Objects.equals(receipt, that.receipt)
                && Objects.equals(paymentId, that.paymentId)
                && Objects.equals(authorId, that.authorId)
                && Objects.equals(resolverId, that.resolverId)
                && Objects.equals(statusId, that.statusId)
                && Objects.equals(typeId, that.typeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, submitted, resolved, description,
                receipt, paymentId, authorId, resolverId, statusId, typeId);
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

