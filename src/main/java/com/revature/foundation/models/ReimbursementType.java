package com.revature.foundation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ers_reimbursement_types")
public class ReimbursementType {

    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String type;

    public ReimbursementType() {
        super();
    }

    public ReimbursementType(String id) {
        this.id = id;
    }

    public ReimbursementType(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public static ReimbursementType getRoleById(String id) {

        switch (id) {
            case "0":
                return new ReimbursementType(id, "LODGING");
            case "1":
                return new ReimbursementType(id, "TRAVEL");
            case "2":
                return new ReimbursementType(id, "FOOD");
            default:
                return new ReimbursementType(id, "OTHER");
        }
    }

    @Override
    public String toString() {
        return "ReimbursementTypes{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
