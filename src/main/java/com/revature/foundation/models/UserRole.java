package com.revature.foundation.models;

import javax.persistence.Embeddable;
import java.util.Objects;

// NOT AN ENTITY
// NO TABLE MAPPED TO THIS CLASS
@Embeddable // can be embedded within an entity class to add to its column list
public class UserRole {

    private String id;
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
