package com.example.project_demo.mapper;

import com.example.project_demo.dto.TeacherDTO;
import com.example.project_demo.entity.TeacherEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherEntity toTeacherEntity(TeacherDTO teacherDTO);
    TeacherDTO toTeacherDTO(TeacherEntity teacherEntity);
}
