package com.example.project_demo.service;

import com.example.project_demo.dto.StudentDTO;

import java.util.List;
import java.util.Map;

public interface StudentService {
    StudentDTO create(StudentDTO studentDTO);
    StudentDTO update(StudentDTO studentDTO);
    StudentDTO findOneById(Long id);
    Map<String, Object> findAllWithPaging(Integer page, Integer size);
    List<StudentDTO> findAll();
    void delete(Long[] ids);
}
