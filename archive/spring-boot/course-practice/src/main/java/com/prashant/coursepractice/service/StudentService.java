package com.prashant.coursepractice.service;

import com.prashant.coursepractice.dto.StudentRequest;
import com.prashant.coursepractice.dto.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> findAll();
    StudentResponse findById(Long id);
    StudentResponse create(StudentRequest request);
    StudentResponse update(Long id,StudentRequest request);
    void delete(Long id);
    List<StudentResponse> searchByName(String name);
}
