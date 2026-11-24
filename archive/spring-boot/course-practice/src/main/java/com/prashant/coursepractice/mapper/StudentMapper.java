package com.prashant.coursepractice.mapper;

import com.prashant.coursepractice.dto.StudentRequest;
import com.prashant.coursepractice.dto.StudentResponse;
import com.prashant.coursepractice.model.Student;

/** Converts between entity and DTOs. */
public final class StudentMapper {
    private StudentMapper() { }

    public static Student toEntity(StudentRequest request) {
        Student s = new Student();
        s.setName(request.getName());
        s.setEmail(request.getEmail());
        return s;
    }

    public static StudentResponse toResponse(Student s) {
        return new StudentResponse(s.getId(), s.getName(), s.getEmail());
    }
}
