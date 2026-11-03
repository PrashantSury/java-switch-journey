package com.prashant.coursepractice.controller;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    // ---- GET /api/students/{id} ----
    // StudentController.one(id) -> GlobalExceptionHandler.notFound (404, STUDENT_NOT_FOUND)
    @Nested
    @DisplayName("GET /api/students/{id}")
    class GetStudentById {

        @Test @DisplayName("GET unknown id returns 404")
        void notFound() throws Exception {
            mvc.perform(get("/api/students/9999"))
               .andExpect(status().isNotFound());
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

        @Test @DisplayName("GET unknown id returns 404 ProblemDetail")
        void notFoundIsProblemDetail() throws Exception {

            mvc.perform(get("/api/students/99999"))
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.status").value(404))
                    .andExpect(jsonPath("$.title").value("Student Not Found"))
                    .andExpect(jsonPath("$.detail").value("Student not found: 99999"))
                    .andExpect(jsonPath("$.errorCode").value("STUDENT_NOT_FOUND"))
                    .andExpect(jsonPath("$.instance").value("/api/students/99999"));
        }
    }

    // ---- POST /api/students ----
    // StudentController.create(request) -> handlers: invalid (400), badJsonOrEmptyJson (400), handleDuplicateEmail (409); 415 comes from the media-type check
    @Nested
    @DisplayName("POST /api/students")
    class CreateStudent {

        @Test @DisplayName("POST valid student returns 201")
        void createValid() throws Exception {
            mvc.perform(post("/api/students").contentType(MediaType.APPLICATION_JSON)
                    .content("{\"name\":\"Prashant\",\"email\":\"p@example.com\"}"))
               .andExpect(status().isCreated())
               .andExpect(jsonPath("$.id").exists())
               .andExpect(jsonPath("$.name").value("Prashant"));
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

        @Test @DisplayName("POST blank name and bad email returns 400 with field errors")
        void createInvalid() throws Exception {
            mvc.perform(post("/api/students").contentType(MediaType.APPLICATION_JSON)
                    .content("{\"name\":\"\",\"email\":\"not-an-email\"}"))
               .andExpect(status().isBadRequest())
               .andExpect(jsonPath("$.errors.name").exists())
               .andExpect(jsonPath("$.errors.email").exists());
        }

        @Test @DisplayName("POST invalid fields returns 400 ProblemDetail listing all errors")
        void validationErrorsAreListed() throws Exception {

            mvc.perform(post("/api/students").contentType(MediaType.APPLICATION_JSON)
                    .content("{\"name\":\"A\",\"email\":\"not-an-email\"}"))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.status").value(400))
                    .andExpect(jsonPath("$.title").value("Validation Failed"))
                    .andExpect(jsonPath("$.errors.name").exists())
                    .andExpect(jsonPath("$.errors.email").exists())
                    .andExpect(jsonPath("$.errorCode").value("VALIDATION_FAILED"));
        }

        @Test @DisplayName("POST malformed JSON returns 400 ProblemDetail")
        void malformedJsonReturnsProblemDetail() throws Exception {

            mvc.perform(post("/api/students").contentType(MediaType.APPLICATION_JSON)
                    .content("{\"name\":"))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.status").value(400))
                    .andExpect(jsonPath("$.title").value("Malformed Request"))
                    .andExpect(jsonPath("$.detail").value("Request body is missing or not valid JSON."))
                    .andExpect(jsonPath("$.errorCode").value("MALFORMED_REQUEST"));
        }

        @Test @DisplayName("POST with a taken email returns 409")
        void createDuplicateEmail() throws Exception {
            createStudent("First", "dup@example.com");

            mvc.perform(post("/api/students")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"name\":\"Second\",\"email\":\"dup@example.com\"}"))
                    .andExpect(status().isConflict());
        }

        @Test @DisplayName("POST with text/plain returns 415, not 500")
        void unsupportedMediaTypeReturns415() throws Exception {
            mvc.perform(post("/api/students")
                            .contentType(MediaType.TEXT_PLAIN)
                            .content("{\"name\":\"Prashant\",\"email\":\"p@example.com\"}"))
                    .andExpect(status().isUnsupportedMediaType())
                    .andExpect(jsonPath("$.status").value(415));
        }
    }

    // ---- PUT /api/students/{id} ----
    // StudentController.update(id, request) -> handlers: notFound (404), handleDuplicateEmail (409)
    @Nested
    @DisplayName("PUT /api/students/{id}")
    class UpdateStudent {

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

        @Test @DisplayName("PUT non-existing student returns 404")
        void updateNonExisting() throws Exception {
            mvc.perform(put("/api/students/99999")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"name\":\"After\",\"email\":\"after@example.com\"}"))
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.detail").value("Student not found: 99999"));
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
    }

    // ---- DELETE /api/students/{id} ----
    // StudentController.delete(id) -> handler: notFound (404)
    @Nested
    @DisplayName("DELETE /api/students/{id}")
    class DeleteStudent {

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
               .andExpect(jsonPath("$.detail").value("Student not found: 99999"));
        }
    }

    // ---- GET /api/students/search ----
    // StudentController.search(name) -> handler: missingParameter (400)
    @Nested
    @DisplayName("GET /api/students/search")
    class SearchStudents {

        @Test @DisplayName("GET search by name returns 200 with matches")
        void searchByName() throws Exception {
            createStudent("SearchableZeta", "zeta@example.com");

            mvc.perform(get("/api/students/search").param("name", "SearchableZeta"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].name").value("SearchableZeta"))
               .andExpect(jsonPath("$[0].email").value("zeta@example.com"));
        }

        @Test @DisplayName("GET search without name returns 400")
        void searchMissingName() throws Exception {
            mvc.perform(get("/api/students/search"))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.detail").value("Required parameter 'name' is missing."));
        }
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
