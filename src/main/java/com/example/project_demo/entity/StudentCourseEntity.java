package com.example.project_demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "student_course")
public class StudentCourseEntity extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private StudentCourseStatusEntity status;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private CourseEntity course;

    public StudentCourseStatusEntity getStatus() {
        return status;
    }

    public void setStatus(StudentCourseStatusEntity status) {
        this.status = status;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }
}
