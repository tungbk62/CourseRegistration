package com.example.project_demo.service.impl;

import com.example.project_demo.dto.TeacherDTO;
import com.example.project_demo.entity.TeacherEntity;
import com.example.project_demo.entity.UserEntity;
import com.example.project_demo.mapper.TeacherMapper;
import com.example.project_demo.repository.TeacherRepository;
import com.example.project_demo.repository.UserRepository;
import com.example.project_demo.service.TeacherService;
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
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    UserRepository userRepository;


    @Override
    public TeacherDTO findOneById(Long id){
        return teacherMapper.toTeacherDTO(teacherRepository.findOneById(id));
    }


    @Override
    public TeacherDTO create(TeacherDTO teacherDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getAuthorities());
        UserEntity userEntity = userRepository.findByUsername(authentication.getName()).orElseThrow(() -> new RuntimeException("username not found"));
        TeacherEntity teacherEntity = teacherMapper.toTeacherEntity(teacherDTO);
        teacherEntity.setUser(userEntity);
        return teacherMapper.toTeacherDTO(teacherRepository.save(teacherEntity));
    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO){
        TeacherEntity oldTeacherEntity = teacherRepository.getById(teacherDTO.getId());
        TeacherEntity newTeacherEntity = teacherMapper.toTeacherEntity(teacherDTO);

        newTeacherEntity.setUser(oldTeacherEntity.getUser());
        newTeacherEntity.setCourses(oldTeacherEntity.getCourses());
        newTeacherEntity.setCreatedBy(oldTeacherEntity.getCreatedBy());
        newTeacherEntity.setCreatedDate(oldTeacherEntity.getCreatedDate());

        return teacherMapper.toTeacherDTO(teacherRepository.save(newTeacherEntity));
    }

    @Override
    public List<TeacherDTO> findAll() {
        List<TeacherEntity> teacherEntities = teacherRepository.findAll();
        List<TeacherDTO> teacherDTOs = new ArrayList<>();
        for(TeacherEntity i : teacherEntities){
            teacherDTOs.add(teacherMapper.toTeacherDTO(i));
        }
        return teacherDTOs;
    }

    @Override
    public Map<String, Object> findAllWithPaging(Integer page, Integer size){
        Map<String, Object> responeResult = new HashMap<>();
        Pageable pageable = PageRequest.of(page, size);

        Page<TeacherEntity> pageResult = teacherRepository.findAll(pageable);
        List<TeacherDTO> teacherDTOs = new ArrayList<>();
        List<TeacherEntity> teacherEntities = pageResult.getContent();

        if(pageResult.hasContent()){
            for(TeacherEntity i : teacherEntities){
                teacherDTOs.add(teacherMapper.toTeacherDTO(i));
            }
        }

        responeResult.put("currentPage", pageResult.getNumber());
        responeResult.put("totalPage", pageResult.getTotalPages());
        responeResult.put("totalItem", pageResult.getTotalElements());
        responeResult.put("students", teacherDTOs);
        return responeResult;
    }

    @Override
    public void delete(Long[] ids){
        for(Long i : ids){
            teacherRepository.deleteById(i);
        }
    }
}
