package com.example.stage1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Name;

    // Constructeur sans argument, requis par JPA
    public Role() {
    }

    // Constructeur avec argument
    public Role(String Name) {
        this.Name = Name;
    }

    // Getters et Setters
    public long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }
}
