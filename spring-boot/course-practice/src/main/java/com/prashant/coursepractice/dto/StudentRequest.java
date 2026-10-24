package com.prashant.coursepractice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/** Incoming JSON for create/update. */
public class StudentRequest {
    // NOTE: id kept only because the current Day02 PUT/DELETE read the id from the body.
    // Once you fix them to use @PathVariable, remove this field.
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @Email(message = "email must be valid")
    @NotBlank(message = "email is required")
    private String email;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
