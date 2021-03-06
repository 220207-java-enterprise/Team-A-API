package com.revature.foundation.models;

import javax.persistence.*;
import java.util.Objects;

// POJO = Plain Ol' Java Object
// Contains NO BUSINESS LOGIC
// Simple encapsulation of some domain object's states
@Entity
@Table(name="ers_users")
public class User {
//this is a comment
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(nullable=false, unique=true)
    private String username;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(name="given_name", nullable = false)
    private String givenName;

    @Column(nullable=false)
    private String surname;

    @Column(name="is_active", columnDefinition = "boolean default false")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRole role;

    public User() {
        super(); // not required, but it bugs me personally not to have it
    }

    public User(String id) {
        this.userId = id;
    }

    public User(String givenName, String surname, String email, String username, String password) {
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String userId, String username, String email, String password, String givenName, String surname, Boolean isActive, UserRole role) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.givenName = givenName;
        this.surname = surname;
        this.isActive = isActive;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }



    public String toFileString() {
        return new StringBuilder(userId).append(":")
                .append(username).append(":")
                .append(email).append(":")
                .append(password).append(":")
                .append(givenName).append(":")
                .append(surname).append(":")
                .append(isActive).append(":")
                .append(role).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User appUser = (User) o;
        return Objects.equals(userId, appUser.userId) && Objects.equals(username, appUser.username) && Objects.equals(email, appUser.email) && Objects.equals(password, appUser.password) && Objects.equals(givenName, appUser.givenName) && Objects.equals(surname, appUser.surname) && Objects.equals(isActive, appUser.isActive) && Objects.equals(role, appUser.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, email, password, givenName, surname, isActive, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", givenName='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", isActive='" + isActive + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}
