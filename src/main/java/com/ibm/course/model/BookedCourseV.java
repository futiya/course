package com.ibm.course.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-06 19:11
 */
@Entity
@Data
@Table(name="booked_course_v")
public class BookedCourseV {
    @Id
    private int id;
    private String userEmail;
    private String name;
    private String mentorName;
    private String skill;
    private Date startTime;
    private Date endTime;
    private  int duration;
    private BigDecimal fee;
    private String description;
    private String status;
    @OneToMany(targetEntity = Rate.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<RateV> rates;

}
