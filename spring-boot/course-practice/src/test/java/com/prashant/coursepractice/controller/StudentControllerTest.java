package com.prashant.coursepractice.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test @DisplayName("POST valid student returns 201")
    void createValid() throws Exception {
        mvc.perform(post("/api/students").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Prashant\",\"email\":\"p@example.com\"}"))
           .andExpect(status().isCreated())
           .andExpect(jsonPath("$.id").exists())
           .andExpect(jsonPath("$.name").value("Prashant"));
    }

    @Test @DisplayName("POST blank name and bad email returns 400 with field errors")
    void createInvalid() throws Exception {
        mvc.perform(post("/api/students").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"\",\"email\":\"not-an-email\"}"))
           .andExpect(status().isBadRequest())
           .andExpect(jsonPath("$.name").exists())
           .andExpect(jsonPath("$.email").exists());
    }

    @Test @DisplayName("GET unknown id returns 404")
    void notFound() throws Exception {
        mvc.perform(get("/api/students/9999"))
           .andExpect(status().isNotFound());
    }
}
