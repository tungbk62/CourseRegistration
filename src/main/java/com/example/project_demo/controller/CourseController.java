package com.example.project_demo.controller;

import com.example.project_demo.dto.CourseDTO;
import com.example.project_demo.dto.StudentCourseDTO;
import com.example.project_demo.service.CourseService;
import com.example.project_demo.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping
    CourseDTO create(@RequestBody CourseDTO courseDTO){
        return courseService.create(courseDTO);
    }

    @PutMapping
    CourseDTO update(@RequestBody CourseDTO courseDTO){
        return courseService.update(courseDTO);
    }

    @DeleteMapping
    void delete(@RequestBody Long[] ids){
        courseService.delete(ids);
    }

    @GetMapping
    List<CourseDTO> findAllByTeacher(@RequestParam("id") Long id){
        return courseService.findAllByTeacher(id);
    }
}
