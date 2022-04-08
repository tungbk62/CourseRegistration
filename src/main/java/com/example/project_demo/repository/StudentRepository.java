package com.example.project_demo.repository;

import com.example.project_demo.entity.StudentEntity;
import com.example.project_demo.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    StudentEntity findOneById(Long id);
    StudentEntity findOneByUser_Id(Long id);
}
