package com.ibm.course.dao;

import com.ibm.course.dto.CourseRateDto;
import com.ibm.course.repository.BookedCourseVRepository;
import com.ibm.course.util.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-06 19:55
 */
@Component
public class BookedCourseDao {
    @Autowired
    BookedCourseVRepository repository;

    public List<CourseRateDto> listInProgressCourseByUser( String userEmail){
       return repository.listCourseByUser(userEmail, StatusEnum.COMPLETE.name());

    }

    public List<CourseRateDto> listCompletedCourseByUser( String userEmail){
        return repository.listCompletedCourseByUser( userEmail);
    };


}
