package com.ibm.course.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-05 17:58
 */
@Data
public class CourseRateDto {
    private Integer id;
    private String name;
    private String mentorName;
    private String skill;
    private Date startTime;
    private Date endTime;
    private BigDecimal fee;
    private Integer rate;
    private String description;
    private Integer duration;

    public CourseRateDto(Integer id, String name, String mentorName, String skill, Date startTime, Date endTime, BigDecimal fee, Integer rate, String description, Integer duration) {
        this.id = id;
        this.name = name;
        this.mentorName = mentorName;
        this.skill = skill;
        this.startTime = startTime;
        this.endTime = endTime;
        this.fee = fee;
        this.rate = rate;
        this.description = description;
        this.duration = duration;
    }

    public CourseRateDto(Integer id, String name, String mentorName, String skill, Date startTime, Date endTime, BigDecimal fee,  String description, Integer duration) {
        this.id = id;
        this.name = name;
        this.mentorName = mentorName;
        this.skill = skill;
        this.startTime = startTime;
        this.endTime = endTime;
        this.fee = fee;
        this.description = description;
        this.duration = duration;
    }
}
