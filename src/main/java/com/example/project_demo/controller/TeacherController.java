package com.example.project_demo.controller;

import com.example.project_demo.dto.TeacherDTO;
import com.example.project_demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping
    TeacherDTO create(@RequestBody TeacherDTO teacherDTO){
        return teacherService.create(teacherDTO);
    }

    @PutMapping
    TeacherDTO update(@RequestBody TeacherDTO teacherDTO){
        return teacherService.update(teacherDTO);
    }

    @DeleteMapping
    void delete(@RequestBody Long[] ids){
        teacherService.delete(ids);
    }

    @GetMapping
    List<TeacherDTO> findAll(){
        return teacherService.findAll();
    }
}
