package com.example.project_demo.mapper;

import com.example.project_demo.dto.StudentDTO;
import com.example.project_demo.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentEntity toStudentEntity(StudentDTO studentDTO);
    StudentDTO toStudentDTO(StudentEntity studentEntity);
}
