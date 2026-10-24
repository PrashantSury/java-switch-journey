package com.prashant.coursepractice.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Student> all() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Student one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@Valid @RequestBody Student student) {
        return repository.save(student);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student update(@Valid @RequestBody Student student) {
          Student st  = repository.findById(student.getId()).orElseThrow(() -> new StudentNotFoundException(student.getId()));
          st.setEmail(student.getEmail());
          st.setName(student.getName());
          return repository.save(st);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @RequestBody Student student) {
        repository.deleteById(student.getId());
    }

    @GetMapping ("/search?name=")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> search(@Valid @RequestParam String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}
