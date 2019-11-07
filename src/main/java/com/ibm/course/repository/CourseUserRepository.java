package com.ibm.course.repository;

import com.ibm.course.model.Course;
import com.ibm.course.model.CourseUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-06 17:43
 */
public interface CourseUserRepository extends JpaRepository<CourseUser, Integer> {

}
