package com.example.stage22.Entity;

import jakarta.persistence.*;

@Entity
@Table(name= "users",uniqueConstraints = @UniqueConstraint(columnNames="email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private String role;
    private String fullname;

    public User() {
        super();
    }

    public User(String email, String password, String role, String fullname) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.fullname = fullname;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

}
