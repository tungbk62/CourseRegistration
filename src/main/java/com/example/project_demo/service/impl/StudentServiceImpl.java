package com.example.project_demo.service.impl;

import com.example.project_demo.dto.StudentDTO;
import com.example.project_demo.entity.StudentEntity;
import com.example.project_demo.entity.UserEntity;
import com.example.project_demo.mapper.StudentMapper;
import com.example.project_demo.repository.StudentRepository;
import com.example.project_demo.repository.UserRepository;
import com.example.project_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentMapper studentMapper;

    @Override
    public StudentDTO findOneById(Long id){
        return studentMapper.toStudentDTO(studentRepository.findOneById(id));
    }

    @Override
    public StudentDTO create(StudentDTO studentDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity = userRepository.findByUsername(authentication.getName()).orElseThrow(() -> new RuntimeException("username not found"));
        StudentEntity studentEntity = studentMapper.toStudentEntity(studentDTO);
        studentEntity.setUser(userEntity);
        return studentMapper.toStudentDTO(studentRepository.save(studentEntity));
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO){
        StudentEntity oldStudentEntity = studentRepository.getById(studentDTO.getId());
        StudentEntity newStudentEntity = studentMapper.toStudentEntity(studentDTO);

        newStudentEntity.setUser(oldStudentEntity.getUser());
        newStudentEntity.setListStudentCourse(oldStudentEntity.getListStudentCourse());
        newStudentEntity.setCreatedBy(oldStudentEntity.getCreatedBy());
        newStudentEntity.setCreatedDate(oldStudentEntity.getCreatedDate());

        return studentMapper.toStudentDTO(studentRepository.save(newStudentEntity));
    }

    @Override
    public Map<String, Object> findAllWithPaging(Integer page, Integer size){
        Map<String, Object> responeResult = new HashMap<>();
        Pageable pageable = PageRequest.of(page, size);

        Page<StudentEntity> pageResult = studentRepository.findAll(pageable);
        List<StudentDTO> studentDTOs = new ArrayList<>();
        List<StudentEntity> studentEntities = pageResult.getContent();

        if(pageResult.hasContent()){
            for(StudentEntity i : studentEntities){
                studentDTOs.add(studentMapper.toStudentDTO(i));
            }
        }

        responeResult.put("currentPage", pageResult.getNumber());
        responeResult.put("totalPage", pageResult.getTotalPages());
        responeResult.put("totalItem", pageResult.getTotalElements());
        responeResult.put("students", studentDTOs);
        return responeResult;
    }

    @Override
    public List<StudentDTO> findAll(){
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDTO> studentDTOs = new ArrayList<>();
        for(StudentEntity i : studentEntities){
            studentDTOs.add(studentMapper.toStudentDTO(i));
        }
        return studentDTOs;
    }


    @Override
    public void delete(Long[] ids){
        for(Long i : ids){
            studentRepository.deleteById(i);
        }
    }

}
