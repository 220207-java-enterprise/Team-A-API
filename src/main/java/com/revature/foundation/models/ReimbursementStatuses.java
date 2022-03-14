package com.revature.foundation.models;

// TODO needs to be an entity and mapped to a table
public class ReimbursementStatuses { // TODO make singular name

    // TODO map columns
    private String id;

    private String status;

    public ReimbursementStatuses() {
        super();
    }

    public ReimbursementStatuses(String id, String status) {
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
        return "ReimbursementStatuses{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
