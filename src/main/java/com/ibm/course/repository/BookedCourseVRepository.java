package com.ibm.course.repository;

import com.ibm.course.dto.CourseRateDto;
import com.ibm.course.model.BookedCourseV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-06 19:18
 */

public interface BookedCourseVRepository extends JpaRepository<BookedCourseV, Integer> {

    @Query("SELECT new com.ibm.course.dto.CourseRateDto(c.id,c.name,c.mentorName,c.skill,c.startTime,c.endTime,c.fee, coalesce(r.rating, 0),c.description, DATEDIFF(c.endTime, c.startTime))"
            + " FROM BookedCourseV c  LEFT JOIN c.rates r   where c.status != :status and c.userEmail=:userEmail  ")

            List<CourseRateDto> listCourseByUser(@Param("userEmail") String userEmail,@Param("status") String status);



    @Query("SELECT new com.ibm.course.dto.CourseRateDto(c.id,c.name,c.mentorName,c.skill,c.startTime,c.endTime,c.fee, coalesce(r.rating, 0),c.description, DATEDIFF(c.endTime, c.startTime))"
            + " FROM BookedCourseV c  LEFT JOIN c.rates r   where c.status = 'COMPLETE' and c.userEmail=:userEmail  ")

    List<CourseRateDto> listCompletedCourseByUser(@Param("userEmail") String userEmail);


}
