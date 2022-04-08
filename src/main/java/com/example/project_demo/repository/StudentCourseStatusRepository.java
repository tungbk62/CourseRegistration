package com.example.project_demo.repository;

import com.example.project_demo.entity.StudentCourseStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseStatusRepository extends JpaRepository<StudentCourseStatusEntity, Long> {
    StudentCourseStatusEntity findOneByCode(String code);
}
