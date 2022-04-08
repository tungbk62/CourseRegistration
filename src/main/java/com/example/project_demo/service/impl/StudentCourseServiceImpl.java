package com.example.project_demo.service.impl;

import com.example.project_demo.dto.CourseDTO;
import com.example.project_demo.dto.StudentCourseDTO;
import com.example.project_demo.dto.StudentCourseStatusDTO;
import com.example.project_demo.dto.StudentDTO;
import com.example.project_demo.entity.*;
import com.example.project_demo.mapper.StudentCourseMapper;
import com.example.project_demo.mapper.StudentCourseStatusMapper;
import com.example.project_demo.mapper.StudentMapper;
import com.example.project_demo.repository.*;
import com.example.project_demo.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    StudentCourseMapper studentCourseMapper;

    @Autowired
    StudentCourseRepository studentCourseRepository;

    @Autowired
    StudentCourseStatusRepository studentCourseStatusRepository;

    @Autowired
    StudentCourseStatusMapper studentCourseStatusMapper;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public StudentCourseDTO create(StudentCourseDTO studentCourseDTO) {
        StudentCourseEntity studentCourseEntity = studentCourseMapper.toStudentCourseEntity(studentCourseDTO);
        StudentCourseStatusEntity studentCourseStatusEntity = studentCourseStatusRepository.findOneByCode("pen");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity = userRepository.findByUsername(authentication.getName()).orElseThrow(() -> new RuntimeException("username not found"));
        StudentEntity studentEntity = studentRepository.findOneByUser_Id(userEntity.getId());

        studentCourseEntity.setStatus(studentCourseStatusEntity);
        studentCourseEntity.setStudent(studentEntity);
        studentCourseEntity.setCourse(courseRepository.getById(studentCourseDTO.getCourse().getId()));

        return studentCourseMapper.toStudentCourseDTO(studentCourseRepository.save(studentCourseEntity));
    }

    @Override
    public StudentCourseDTO update(StudentCourseDTO studentCourseDTO) {
        StudentCourseEntity oldStudentCourseEntity = studentCourseRepository.getById(studentCourseDTO.getId());
        StudentCourseEntity newStudentCourseEntity = studentCourseMapper.toStudentCourseEntity(studentCourseDTO);

        newStudentCourseEntity.setStatus(studentCourseStatusRepository.findOneByCode(studentCourseDTO.getStatus().getCode()));
        newStudentCourseEntity.setCourse(oldStudentCourseEntity.getCourse());
        newStudentCourseEntity.setStudent(oldStudentCourseEntity.getStudent());
        newStudentCourseEntity.setCreatedBy(oldStudentCourseEntity.getCreatedBy());
        newStudentCourseEntity.setCreatedDate(oldStudentCourseEntity.getCreatedDate());

        return checkStatus(newStudentCourseEntity);
    }

    @Override
    public void delete(Long[] ids) {
        for(Long i : ids){
            studentCourseRepository.deleteById(i);
        }
    }

    @Override
    public List<StudentCourseDTO> findAllByStudent(Long id) {
        List<StudentCourseEntity> studentCourseEntities = studentCourseRepository.findAllByStudent_Id(id);
        List<StudentCourseDTO> studentCourseDTOs = new ArrayList<>();
        for(StudentCourseEntity i : studentCourseEntities){
            studentCourseDTOs.add(studentCourseMapper.toStudentCourseDTO(i));
        }
        return studentCourseDTOs;
    }

    @Override
    public List<StudentCourseDTO> findAllByCourse(Long id) {
        List<StudentCourseEntity> studentCourseEntities = studentCourseRepository.findAllByCourse_Id(id);
        List<StudentCourseDTO> studentCourseDTOs = new ArrayList<>();
        for(StudentCourseEntity i : studentCourseEntities){
            studentCourseDTOs.add(studentCourseMapper.toStudentCourseDTO(i));
        }
        return studentCourseDTOs;
    }

    private StudentCourseDTO checkStatus(StudentCourseEntity studentCourseEntity){
        StudentCourseDTO studentCourseDTO;
        String code = studentCourseEntity.getStatus().getCode();
        if(code.equals("app")){
            studentCourseDTO = handleApprovalStatus(studentCourseEntity);
        }else if(code.equals("den")){
            studentCourseDTO = handleDeniedStatus(studentCourseEntity);
        }else {
            throw new RuntimeException("do not pending in update method");
        }
        return studentCourseDTO;
    }

    private StudentCourseDTO handleApprovalStatus(StudentCourseEntity studentCourseEntity){
        CourseEntity courseEntity = studentCourseEntity.getCourse();

        if(courseEntity.getCurrentNumberStudent() < courseEntity.getMaxNumberStudent()){
            courseEntity.setCurrentNumberStudent(courseEntity.getCurrentNumberStudent() + 1);
            courseRepository.save(courseEntity);
        }else {
            studentCourseEntity.setStatus(studentCourseStatusRepository.findOneByCode("den"));
        }
        return studentCourseMapper.toStudentCourseDTO(studentCourseRepository.save(studentCourseEntity));
    }

    private StudentCourseDTO handleDeniedStatus(StudentCourseEntity studentCourseEntity){
        return studentCourseMapper.toStudentCourseDTO(studentCourseRepository.save(studentCourseEntity));
    }

}
