package com.example.project_demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_course_status")
public class StudentCourseStatusEntity extends BaseEntity {
    @Column(name = "code", unique = true) //pen, app, den
    private String code;

    @Column(name = "name") //pending, approval, denied
    private String name;

    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    List<StudentCourseEntity> listStudentCourse = new ArrayList<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentCourseEntity> getListStudentCourse() {
        return listStudentCourse;
    }

    public void setListStudentCourse(List<StudentCourseEntity> listStudentCourse) {
        this.listStudentCourse = listStudentCourse;
    }
}
