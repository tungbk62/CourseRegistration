package com.example.project_demo.service.impl;

import com.example.project_demo.dto.CourseDTO;
import com.example.project_demo.entity.CourseEntity;
import com.example.project_demo.entity.TeacherEntity;
import com.example.project_demo.entity.UserEntity;
import com.example.project_demo.mapper.CourseMapper;
import com.example.project_demo.repository.*;
import com.example.project_demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentCourseRepository studentCourseRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseMapper courseMapper;


    @Override
    public CourseDTO create(CourseDTO courseDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity = userRepository.findByUsername(authentication.getName()).orElseThrow(() -> new RuntimeException("username not found"));
        TeacherEntity teacherEntity = teacherRepository.findOneByUser_Id(userEntity.getId());
        CourseEntity courseEntity = courseMapper.toCourseEntity(courseDTO);
        courseEntity.setTeacher(teacherEntity);

        return courseMapper.toCourseDTO(courseRepository.save(courseEntity));
    }

    @Override
    public CourseDTO update(CourseDTO courseDTO) {
        CourseEntity newCourseEntity = courseMapper.toCourseEntity(courseDTO);
        CourseEntity oldCourseEntity = courseRepository.getById(courseDTO.getId());

        newCourseEntity.setCreatedBy(oldCourseEntity.getCreatedBy());
        newCourseEntity.setCreatedDate(oldCourseEntity.getCreatedDate());
        newCourseEntity.setTeacher(oldCourseEntity.getTeacher());
        newCourseEntity.setListStudentCourse(oldCourseEntity.getListStudentCourse());


        return courseMapper.toCourseDTO(courseRepository.save(newCourseEntity));
    }

    @Override
    public void delete(Long[] ids) {
        for(Long i : ids){
            courseRepository.deleteById(i);
        }
    }

    @Override
    public List<CourseDTO> findAllByTeacher(Long id) {
        List<CourseEntity> courseEntities = courseRepository.findAllByTeacher_Id(id);
        List<CourseDTO> courseDTOs = new ArrayList<>();
        for(CourseEntity i : courseEntities){
            courseDTOs.add(courseMapper.toCourseDTO(i));
        }
        return courseDTOs;
    }
}
