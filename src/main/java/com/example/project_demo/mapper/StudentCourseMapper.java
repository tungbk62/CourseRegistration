package com.example.project_demo.mapper;

import com.example.project_demo.dto.StudentCourseDTO;
import com.example.project_demo.dto.StudentDTO;
import com.example.project_demo.entity.StudentCourseEntity;
import com.example.project_demo.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentCourseMapper {
    StudentCourseDTO toStudentCourseDTO(StudentCourseEntity studentCourseEntity);
    StudentCourseEntity toStudentCourseEntity(StudentCourseDTO studentCourseDTO);
}
