package com.prashant.coursepractice.controller;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test @DisplayName("POST with a taken email returns 409")
    void createDuplicateEmail() throws Exception {
        createStudent("First", "dup@example.com");

        mvc.perform(post("/api/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Second\",\"email\":\"dup@example.com\"}"))
                .andExpect(status().isConflict());
    }

    @Test @DisplayName("PUT with another student's email returns 409")
    void updateWithAnotherStudentsEmail() throws Exception {
        createStudent("Owner", "owner@example.com");
        long otherId = createStudent("Other", "other@example.com");

        mvc.perform(put("/api/students/" + otherId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Other\",\"email\":\"owner@example.com\"}"))
                .andExpect(status().isConflict());
    }

    @Test @DisplayName("GET unknown id returns 404")
    void notFound() throws Exception {
        mvc.perform(get("/api/students/9999"))
           .andExpect(status().isNotFound());
    }

    @Test @DisplayName("POST valid student returns 201 and Location /api/students/{id}")
    void createReturnsLocation() throws Exception {
        MvcResult result = mvc.perform(post("/api/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"LocationCheck\",\"email\":\"loc@example.com\"}"))
           .andExpect(status().isCreated())
           .andExpect(jsonPath("$.id").exists())
           .andExpect(jsonPath("$.name").value("LocationCheck"))
           .andReturn();

        long id = jsonId(result);
        assertEquals("/api/students/" + id, result.getResponse().getHeader("Location"));
    }

    @Test @DisplayName("GET by id returns 200")
    void getById() throws Exception {
        long id = createStudent("GetMe", "get@example.com");

        mvc.perform(get("/api/students/" + id))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.id").value(Math.toIntExact(id)))
           .andExpect(jsonPath("$.name").value("GetMe"))
           .andExpect(jsonPath("$.email").value("get@example.com"));
    }

    @Test @DisplayName("GET search without name returns 400")
    void searchMissingName() throws Exception {
        mvc.perform(get("/api/students/search"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("name parameter is missing"));
    }

    @Test @DisplayName("PUT existing student returns 200")
    void updateExisting() throws Exception {
        long id = createStudent("Before", "before@example.com");

        mvc.perform(put("/api/students/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"After\",\"email\":\"after@example.com\"}"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.id").value(Math.toIntExact(id)))
           .andExpect(jsonPath("$.name").value("After"))
           .andExpect(jsonPath("$.email").value("after@example.com"));
    }

    @Test @DisplayName("PUT non-existing student returns 404")
    void updateNonExisting() throws Exception {
        mvc.perform(put("/api/students/99999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"After\",\"email\":\"after@example.com\"}"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Student not found: 99999"));
    }

    @Test @DisplayName("PUT with own unchanged email returns 200")
    void updateKeepingOwnEmail() throws Exception {
        long id = createStudent("Keeper", "keep@example.com");

        mvc.perform(put("/api/students/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"KeeperRenamed\",\"email\":\"keep@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(Math.toIntExact(id)))
                .andExpect(jsonPath("$.name").value("KeeperRenamed"))
                .andExpect(jsonPath("$.email").value("keep@example.com"));
    }

    @Test @DisplayName("DELETE existing student returns 204 with an empty body")
    void deleteExisting() throws Exception {
        long id = createStudent("DeleteMe", "del@example.com");

        mvc.perform(delete("/api/students/" + id))
           .andExpect(status().isNoContent())
           .andExpect(content().string(""));
    }

    @Test @DisplayName("DELETE unknown id returns 404")
    void deleteUnknown() throws Exception {
        mvc.perform(delete("/api/students/99999"))
           .andExpect(status().isNotFound())
           .andExpect(jsonPath("$.error").value("Student not found: 99999"));
    }

    @Test @DisplayName("GET search by name returns 200 with matches")
    void searchByName() throws Exception {
        createStudent("SearchableZeta", "zeta@example.com");

        mvc.perform(get("/api/students/search").param("name", "SearchableZeta"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].name").value("SearchableZeta"))
           .andExpect(jsonPath("$[0].email").value("zeta@example.com"));
    }

    private long createStudent(String name, String email) throws Exception {
        MvcResult result = mvc.perform(post("/api/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"" + name + "\",\"email\":\"" + email + "\"}"))
           .andExpect(status().isCreated())
           .andReturn();
        return jsonId(result);
    }

    private static long jsonId(MvcResult result) throws Exception {
        Number id = JsonPath.read(result.getResponse().getContentAsString(), "$.id");
        return id.longValue();
    }
}
