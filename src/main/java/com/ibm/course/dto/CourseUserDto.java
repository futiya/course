package com.ibm.course.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-06 17:49
 */
@Data
public class CourseUserDto {
    private Integer id;
    private Integer courseId;
    private String userName;
    private String userEmail;
    private String mentorName;
    private Float cost;
    private Date startDate;
    private Date endDate;
    private Float fee;
}
