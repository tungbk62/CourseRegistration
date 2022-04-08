package com.example.project_demo.service;

import com.example.project_demo.dto.CourseDTO;
import com.example.project_demo.dto.StudentCourseDTO;
import com.example.project_demo.dto.StudentDTO;

import java.util.List;

public interface StudentCourseService {
    StudentCourseDTO create(StudentCourseDTO studentCourseDTO);
    StudentCourseDTO update(StudentCourseDTO studentCourseDTO);
    void delete(Long[] ids);
    List<StudentCourseDTO> findAllByStudent(Long id);
    List<StudentCourseDTO> findAllByCourse(Long id);
}
