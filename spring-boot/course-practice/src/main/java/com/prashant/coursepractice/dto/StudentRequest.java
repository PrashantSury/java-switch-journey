package com.prashant.coursepractice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/** Incoming JSON for create/update. */
public class StudentRequest {

    @Size(min=2, max=50)
    @NotBlank(message = "name is required")
    private String name;

    @Email(message = "email must be valid")
    @NotBlank(message = "email is required")
    private String email;

   
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
