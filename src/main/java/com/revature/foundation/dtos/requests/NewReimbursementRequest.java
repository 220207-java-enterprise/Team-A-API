package com.revature.foundation.dtos.requests;

import com.revature.foundation.models.Reimbursement;
import com.revature.foundation.models.ReimbursementType;
import com.revature.foundation.models.User;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class NewReimbursementRequest {

    private double amount;
    private Timestamp submitted;
    private String description;
    private String authorId;
    private String typeId;

    public NewReimbursementRequest() {
        super();
    }

    public NewReimbursementRequest(double amount, Timestamp submitted, String description, String authorId, String type) {
        this.amount = amount;
        this.submitted = submitted;
        this.description = description;
        this.authorId = authorId;
        this.typeId = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "NewReimbursementRequest{" +
                "amount=" + amount +
                ", submitted='" + submitted + '\'' +
                ", description='" + description + '\'' +
                ", authorId='" + authorId + '\'' +
                ", typeId=" + typeId +
                '}';
    }

    public Reimbursement extractReimbursement() {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setId(UUID.randomUUID().toString());
        reimbursement.setAmount(this.amount);
        reimbursement.setSubmitted(Timestamp.valueOf(LocalDateTime.now()));
        reimbursement.setDescription(this.description);
        reimbursement.setAuthorId(new User(this.authorId)); // note this doesn't include other user info besides id
        reimbursement.setTypeId(ReimbursementType.getRoleById(this.typeId));
        return reimbursement;
    }

}
