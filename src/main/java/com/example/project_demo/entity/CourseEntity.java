package com.example.project_demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Course")
public class CourseEntity extends BaseEntity{

    @Column(unique = true, name = "course_name")
    private String courseName;

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
    @JoinColumn(name = "category_id", referencedColumnName = )
    private CategoryEntity category;



}
