package com.ibm.course.dao;

import com.ibm.course.model.Course;
import com.ibm.course.model.CourseUser;
import com.ibm.course.repository.CourseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-06 17:44
 */
@Component
public class CourseUserDao {
    @Autowired
    private CourseUserRepository repository;
    public void addCourse(CourseUser courseUser) {
        repository.save(courseUser);
    }
}
