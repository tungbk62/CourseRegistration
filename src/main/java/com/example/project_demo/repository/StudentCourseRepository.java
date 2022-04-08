package com.example.project_demo.repository;

import com.example.project_demo.entity.StudentCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourseEntity, Long> {
    List<StudentCourseEntity> findAllByStudent_Id(Long id);
    List<StudentCourseEntity> findAllByCourse_Id(Long id);
}
