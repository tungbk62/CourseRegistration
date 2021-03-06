package com.example.project_demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Course")
public class CourseEntity extends BaseEntity{

    @Column(unique = true, name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "time_start")
    private Date timeStart;

    @Column(name = "time_end")
    private Date timeEnd;

    @Column(name = "max_number_student")
    private Integer maxNumberStudent;

    @Column(name = "current_number_student")
    private Integer currentNumberStudent;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private TeacherEntity teacher;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<StudentCourseEntity> listStudentCourse = new ArrayList<>();

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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    public List<StudentCourseEntity> getListStudentCourse() {
        return listStudentCourse;
    }

    public void setListStudentCourse(List<StudentCourseEntity> listStudentCourse) {
        this.listStudentCourse = listStudentCourse;
    }
}
