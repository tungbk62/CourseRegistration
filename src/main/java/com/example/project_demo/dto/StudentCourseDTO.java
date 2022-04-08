package com.example.project_demo.dto;

public class StudentCourseDTO extends BaseDTO {
    private StudentCourseStatusDTO status;
    private StudentDTO student;
    private CourseDTO course;

    public StudentCourseStatusDTO getStatus() {
        return status;
    }

    public void setStatus(StudentCourseStatusDTO status) {
        this.status = status;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }
}
