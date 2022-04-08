package com.example.project_demo.service;

import com.example.project_demo.dto.StudentDTO;
import com.example.project_demo.dto.TeacherDTO;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    TeacherDTO create(TeacherDTO teacherDTO);
    TeacherDTO update(TeacherDTO teacherDTO);
    TeacherDTO findOneById(Long id);
    List<TeacherDTO> findAll();
    Map<String, Object> findAllWithPaging(Integer page, Integer size);
    void delete(Long[] ids);
}
