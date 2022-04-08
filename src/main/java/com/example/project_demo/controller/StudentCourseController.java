package com.example.project_demo.controller;

import com.example.project_demo.dto.StudentCourseDTO;
import com.example.project_demo.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/student-course")
public class StudentCourseController {
    @Autowired
    StudentCourseService studentCourseService;

    @PostMapping
    StudentCourseDTO create(@RequestBody StudentCourseDTO studentCourseDTO){
        return studentCourseService.create(studentCourseDTO);
    }

    @PutMapping
    StudentCourseDTO update(@RequestBody StudentCourseDTO studentCourseDTO){
        return studentCourseService.update(studentCourseDTO);
    }

    @DeleteMapping
    void delete(@RequestBody Long[] ids){
        studentCourseService.delete(ids);
    }

    @GetMapping(value = "/student")
    List<StudentCourseDTO> findAllByStudent(@RequestParam("studentId") Long id){
        return studentCourseService.findAllByStudent(id);
    }

    @GetMapping(value = "/course")
    List<StudentCourseDTO> findAllByCourse(@RequestParam("courseId") Long id){
        return studentCourseService.findAllByCourse(id);
    }
}
