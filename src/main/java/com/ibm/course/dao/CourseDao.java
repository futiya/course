package com.ibm.course.dao;

import com.ibm.course.dto.CourseRateDto;
import com.ibm.course.model.Course;
import com.ibm.course.repository.CourseRepository;
import com.ibm.course.util.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-05 23:28
 */
@Component
public class CourseDao {
    @Autowired
    private CourseRepository repository;

    public  List<CourseRateDto> listAll(){
        List<CourseRateDto> courseRateDtos = repository.listAll();
        return courseRateDtos;
    }

    public void addCourse(Course course) {
        repository.save(course);
    }

    public  List<CourseRateDto> findMentorCourse(String email, Enum status) {
        List<CourseRateDto> courses =  repository.queryCourseByMentorProgress(email,status.name());
        return courses;
    }

    public List<CourseRateDto> findAvalibleCourses() {
        List<CourseRateDto> courses =  repository.queryAvailibleCourse(StatusEnum.AVALIBLE.name());
        return courses;
    }
}
