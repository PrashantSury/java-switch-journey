package com.prashant.coursepractice.service.impl;

import com.prashant.coursepractice.dto.StudentRequest;
import com.prashant.coursepractice.dto.StudentResponse;
import com.prashant.coursepractice.exception.DuplicateEmailException;
import com.prashant.coursepractice.exception.StudentNotFoundException;
import com.prashant.coursepractice.mapper.StudentMapper;
import com.prashant.coursepractice.model.Student;
import com.prashant.coursepractice.repository.StudentRepository;
import com.prashant.coursepractice.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StudentResponse> findAll() {
        return repository.findAll().stream().map(StudentMapper::toResponse).toList();
    }

    @Override
    public StudentResponse findById(Long id) {
        return StudentMapper.toResponse(
                repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id)));
    }

    @Override
    public StudentResponse create(StudentRequest request) {
        if (repository.existsByEmailIgnoreCase(request.getEmail())) {
            throw new DuplicateEmailException(request.getEmail());
        }
        return StudentMapper.toResponse(repository.save(StudentMapper.toEntity(request)));
    }

    @Override
    public StudentResponse update(Long id,StudentRequest request) {
        Student st = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        if (repository.existsByEmailIgnoreCaseAndIdNot(request.getEmail(), id)) {
            throw new DuplicateEmailException(request.getEmail());
        }
        st.setEmail(request.getEmail());
        st.setName(request.getName());
        return StudentMapper.toResponse(repository.save(st));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<StudentResponse> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name).stream().map(StudentMapper::toResponse).toList();
    }
}
