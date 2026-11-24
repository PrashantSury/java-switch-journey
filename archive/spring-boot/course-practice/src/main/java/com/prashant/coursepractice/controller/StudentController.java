package com.prashant.coursepractice.controller;

import com.prashant.coursepractice.dto.StudentRequest;
import com.prashant.coursepractice.dto.StudentResponse;
import com.prashant.coursepractice.service.StudentService;
import jakarta.validation.Valid;
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

    // ===== GET /api/students -> 200 list (no error path; no test yet) =====
    @GetMapping
    public List<StudentResponse> all() {
        return service.findAll();
    }

    // ===== GET /api/students/{id} -> 200 | 404 notFound | tests: GET /{id} section =====
    @GetMapping("/{id}")
    public StudentResponse one(@PathVariable Long id) {
        return service.findById(id);
    }

    // ===== GET /api/students/search?name= -> 200 | 400 missingParameter | tests: GET /search section =====
    @GetMapping("/search")
    public ResponseEntity<List<StudentResponse>> search(@RequestParam String name) {
        return ResponseEntity.ok(service.searchByName(name));
    }

    // ===== POST /api/students -> 201 + Location | 400 invalid / badJsonOrEmptyJson | 409 handleDuplicateEmail | 415 unsupportedMediaType | tests: POST section =====
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

    // ===== PUT /api/students/{id} -> 200 | 400 as POST | 404 notFound | 409 handleDuplicateEmail | tests: PUT section =====
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(
            @PathVariable Long id, @Valid @RequestBody StudentRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    // ===== DELETE /api/students/{id} -> 204 | 404 notFound | tests: DELETE section =====
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
