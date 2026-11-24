package com.prashant.coursepractice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/** JPA entity: maps to the student table. No validation or web concerns here. */
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
