package com.revature.foundation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ers_reimbursement_statuses")
public class ReimbursementStatus {

    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String status;

    public ReimbursementStatus() {
        super();
    }

    public ReimbursementStatus(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReimbursementStatus{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
