package com.example.project_demo.repository;

import com.example.project_demo.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
    TeacherEntity findOneById(Long id);

//    @Query(value = "select * from teacher where user_id = :id", nativeQuery = true)
    TeacherEntity findOneByUser_Id(Long id);
}
