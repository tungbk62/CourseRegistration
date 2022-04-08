package com.example.project_demo.service;

import com.example.project_demo.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    CourseDTO create(CourseDTO courseDTO);
    CourseDTO update(CourseDTO courseDTO);
    void delete(Long[] ids);
    List<CourseDTO> findAllByTeacher(Long id);
}
