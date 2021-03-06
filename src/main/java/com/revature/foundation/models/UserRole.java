package com.revature.foundation.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ers_user_roles")
public class UserRole {

    @Id
    private String id;

    @Column(name = "role", nullable = false, unique = true)
    private String roleName;

    public UserRole() {
        super();
    }

    public UserRole(String id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRoles = (UserRole) o;
        return Objects.equals(id, userRoles.id) && Objects.equals(roleName, userRoles.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName);
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }

}
