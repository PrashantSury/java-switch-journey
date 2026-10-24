package com.prashant.coursepractice.controller;

import com.prashant.coursepractice.dto.StudentRequest;
import com.prashant.coursepractice.dto.StudentResponse;
import com.prashant.coursepractice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse create(@Valid @RequestBody StudentRequest request) {
        return service.create(request);
    }

    // TODO(Day02): your PUT/DELETE/search mapping fixes go here (see tasks/day02-morning.md)
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse update(@Valid @RequestBody StudentRequest request) {
        return service.update(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @RequestBody StudentRequest request) {
        service.delete(request);
    }

    @GetMapping ("/search?name=")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> search(@Valid @RequestParam String name) {
        return service.searchByName(name);
    }
}
