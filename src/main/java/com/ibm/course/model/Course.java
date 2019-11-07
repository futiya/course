package com.ibm.course.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-05 17:46
 */
@Entity
@Data
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String email;
    private String skill;
    private String mentorName;
    private BigDecimal fee;
    private String status;
    private int progress;
    private Date startTime;
    private Date endTime;
    @OneToMany(targetEntity = Rate.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<RateV> rates;
}
