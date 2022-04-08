package com.example.project_demo.controller;

import com.example.project_demo.dto.StudentDTO;
import com.example.project_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping
    StudentDTO create(@RequestBody StudentDTO studentDTO){
        return studentService.create(studentDTO);
    }

    @PutMapping
    StudentDTO update(@RequestBody StudentDTO studentDTO){
        return studentService.update(studentDTO);
    }

    @DeleteMapping
    void delete(Long[] ids){
        studentService.delete(ids);
    }

    @GetMapping
    List<StudentDTO> findAll(){
        return studentService.findAll();
    }

}
