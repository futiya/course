package com.ibm.course.repository;

import com.ibm.course.dto.CourseRateDto;
import com.ibm.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-05 18:07
 */

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("SELECT new com.ibm.course.dto.CourseRateDto(c.id,c.name,c.mentorName,c.skill,c.startTime,c.endTime,c.fee, coalesce(r.rating, 0),c.description, DATEDIFF(c.endTime, c.startTime))"
            + " FROM Course c LEFT JOIN c.rates r ")
    List<CourseRateDto> listAll();

    @Query("SELECT new com.ibm.course.dto.CourseRateDto(c.id,c.name,c.mentorName,c.skill,c.startTime,c.endTime,c.fee, coalesce(r.rating, 0),c.description, DATEDIFF(c.endTime, c.startTime))"
            + " FROM Course c  LEFT JOIN c.rates r   where c.status = :status and c.email=:email  ")
    List<CourseRateDto> queryCourseByMentorProgress(@Param("email") String email, @Param("status") String status);

    @Query("SELECT new com.ibm.course.dto.CourseRateDto(c.id,c.name,c.mentorName,c.skill,c.startTime,c.endTime,c.fee, coalesce(r.rating, 0),c.description, DATEDIFF(c.endTime, c.startTime))"
            + " FROM Course c  LEFT JOIN c.rates r   where c.status = :status ")
    List<CourseRateDto> queryAvailibleCourse( @Param("status") String status);
}
