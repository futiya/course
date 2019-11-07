package com.ibm.course.service;

import com.ibm.course.dao.BookedCourseDao;
import com.ibm.course.dao.CourseDao;
import com.ibm.course.dao.CourseUserDao;
import com.ibm.course.dto.CourseRateDto;
import com.ibm.course.dto.CourseUserDto;
import com.ibm.course.dto.RspModel;
import com.ibm.course.model.Course;
import com.ibm.course.model.CourseUser;
import com.ibm.course.util.StatusEnum;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-05 23:32
 */
@Service
public class CourseService {
    @Autowired
    private CourseDao dao;
    @Autowired
    private CourseUserDao daoUser;
    @Autowired
    private BookedCourseDao bookedCourseDao;

    public List<CourseRateDto> listAll(){
        List<CourseRateDto> dtos =dao.listAll();
        return dtos;
    }

    public void addCourse(Course course) {
        dao.addCourse(course);
    }

    public List<CourseRateDto> findCurrentMentorCourse(String email) {
        List<CourseRateDto> courses =  dao.findMentorCourse(email, StatusEnum.INPROGRESS);
        return courses;
    }

    public List<CourseRateDto> findCompletedTranings(String email) {
        List<CourseRateDto> courses =  dao.findMentorCourse(email, StatusEnum.COMPLETE);
        return courses;
    }

    public List<CourseRateDto> findMentorAvailableCourse(String email) {
        List<CourseRateDto> courses =  dao.findMentorCourse(email, StatusEnum.AVALIBLE);
        return courses;
    }

    public List<CourseRateDto> searchCourses() {
        List<CourseRateDto> courses =  dao.findAvalibleCourses();
        return courses;
    }

    public List<CourseRateDto> searchBookedCourses(String userEmail) {
        List<CourseRateDto> courses =  bookedCourseDao.listInProgressCourseByUser(userEmail);
        return courses;
    }
    public List<CourseRateDto> searchCompletedBookedCourses(String userEmail) {
        List<CourseRateDto> courses =  bookedCourseDao.listCompletedCourseByUser(userEmail);
        return courses;
    }

    public void bookCourse(CourseUserDto dto) {
        CourseUser courseUser = new CourseUser();
        courseUser.setCourseId(dto.getCourseId());
        courseUser.setUserEmail(dto.getUserName());
        daoUser.addCourse(courseUser);
    }
}
