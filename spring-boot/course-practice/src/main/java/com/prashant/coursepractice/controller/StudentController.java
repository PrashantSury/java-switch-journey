package com.prashant.coursepractice.controller;

import com.prashant.coursepractice.dto.StudentRequest;
import com.prashant.coursepractice.dto.StudentResponse;
import com.prashant.coursepractice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/** HTTP only: mapping, validation trigger, status codes. Logic lives in StudentService. */
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // GET /api/students -> 200 list. No error handler involved (no test yet).
    @GetMapping
    public List<StudentResponse> all() {
        return service.findAll();
    }

    // GET /api/students/{id} -> 200, or 404 via GlobalExceptionHandler.notFound.
    // Tests: StudentControllerTest.GetStudentById
    @GetMapping("/{id}")
    public StudentResponse one(@PathVariable Long id) {
        return service.findById(id);
    }

    // POST /api/students -> 201 + Location; 400 validation / malformed JSON, 409 duplicate email, 415 wrong media type.
    // Tests: StudentControllerTest.CreateStudent
    @PostMapping
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentRequest request) {

        StudentResponse createdStudent =
                service.create(request);

        URI location = URI.create(
                "/api/students/" + createdStudent.id());

        return ResponseEntity
                .created(location)
                .body(createdStudent);
    }

    // PUT /api/students/{id} -> 200; 404 unknown id, 409 email owned by another student, 400 as POST.
    // Tests: StudentControllerTest.UpdateStudent
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(
            @PathVariable Long id, @Valid @RequestBody StudentRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    // DELETE /api/students/{id} -> 204; 404 unknown id.
    // Tests: StudentControllerTest.DeleteStudent
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/students/search?name= -> 200; 400 when "name" is missing (GlobalExceptionHandler.missingParameter).
    // Tests: StudentControllerTest.SearchStudents
    @GetMapping("/search")
    public ResponseEntity<List<StudentResponse>> search(@RequestParam String name) {
        return ResponseEntity.ok(service.searchByName(name));
    }
}
