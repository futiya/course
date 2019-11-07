package com.ibm.course.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-05 17:42
 */
@Entity
@Data
@Table(name = "rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   // private int courseId;
    private int rating;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "course_id", insertable = false, updatable = false)
//    @Fetch(FetchMode.JOIN)
//    private Course course;
}
