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

    @GetMapping
    public List<StudentResponse> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public StudentResponse one(@PathVariable Long id) {
        return service.findById(id);
    }

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

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(
            @PathVariable Long id, @Valid @RequestBody StudentRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/search")
    public ResponseEntity<List<StudentResponse>> search(@RequestParam String name) {
        List<StudentResponse> studentResponse = service.searchByName(name);

        if(studentResponse!=null){
            return ResponseEntity.ok(studentResponse);
        } else{
            return ResponseEntity.notFound().build();
    }
  }

}
