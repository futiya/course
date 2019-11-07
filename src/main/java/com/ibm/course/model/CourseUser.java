package com.ibm.course.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-06 17:40
 */
@Entity
@Data
@Table(name = "course_user")
public class CourseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userEmail;
    private int courseId;
}
