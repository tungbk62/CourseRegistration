package com.example.project_demo.dto;

import com.example.project_demo.entity.CategoryEntity;
import com.example.project_demo.entity.StudentCourseEntity;
import com.example.project_demo.entity.TeacherEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseDTO extends BaseDTO{
    private String name;
    private String description;
    private Date timeStart;
    private Date timeEnd;
    private Integer maxNumberStudent;
    private Integer currentNumberStudent;
    private CategoryDTO category;
    private TeacherDTO teacher;

//    @JsonIgnore
//    private List<StudentCourseDTO> listStudentCourse = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Integer getMaxNumberStudent() {
        return maxNumberStudent;
    }

    public void setMaxNumberStudent(Integer maxNumberStudent) {
        this.maxNumberStudent = maxNumberStudent;
    }

    public Integer getCurrentNumberStudent() {
        return currentNumberStudent;
    }

    public void setCurrentNumberStudent(Integer currentNumberStudent) {
        this.currentNumberStudent = currentNumberStudent;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

//    public List<StudentCourseDTO> getListStudentCourse() {
//        return listStudentCourse;
//    }
//
//    public void setListStudentCourse(List<StudentCourseDTO> listStudentCourse) {
//        this.listStudentCourse = listStudentCourse;
//    }
}
