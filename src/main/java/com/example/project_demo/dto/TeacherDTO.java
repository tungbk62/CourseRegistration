package com.example.project_demo.dto;

import com.example.project_demo.entity.CourseEntity;
import com.example.project_demo.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherDTO extends BaseDTO{
    private String name;
    private String description;
    private Date birthday;
    private String address;
    private String phone;
    private String email;
//    @JsonIgnore
//    private UserEntity user;
//
//    @JsonIgnore
//    List<CourseDTO> courses = new ArrayList<>();

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public UserEntity getUser() {
//        return user;
//    }
//
//    public void setUser(UserEntity user) {
//        this.user = user;
//    }
//
//    public List<CourseDTO> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<CourseDTO> courses) {
//        this.courses = courses;
//    }
}
