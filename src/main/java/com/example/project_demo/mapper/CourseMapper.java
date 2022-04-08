package com.example.project_demo.mapper;

import com.example.project_demo.dto.CourseDTO;
import com.example.project_demo.entity.CourseEntity;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseMapper {
//    CourseMapper MAPPER = Mappers.getMapper(CourseMapper.class);

    CourseEntity toCourseEntity(CourseDTO courseDTO);

    CourseDTO toCourseDTO(CourseEntity courseEntity);
}
