package com.example.project_demo.mapper;

import com.example.project_demo.dto.StudentCourseStatusDTO;
import com.example.project_demo.entity.StudentCourseStatusEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentCourseStatusMapper {
    StudentCourseStatusDTO toStudentCourseStatusDTO(StudentCourseStatusEntity studentCourseStatusEntity);
    StudentCourseStatusEntity toStudentCourseStatusEntity(StudentCourseStatusDTO studentCourseStatusDTO);
}
