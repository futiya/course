package com.ibm.course.controller;

import com.ibm.course.dto.CourseRateDto;
import com.ibm.course.dto.RspModel;
import com.ibm.course.model.Course;
import com.ibm.course.service.CourseService;
import com.ibm.course.util.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-06 09:33
 */
@RestController
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    private CourseService service;

    @RequestMapping(value = "/addcourse", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<RspModel> addCourse(@RequestBody Course course) {

        try {
            course.setStatus(StatusEnum.AVALIBLE.getName());
            service.addCourse(course);

            RspModel rsp = new RspModel();
            rsp.setCode(200);
            rsp.setMessage("Course Created");
            return new ResponseEntity<RspModel>(rsp, HttpStatus.CREATED);

        } catch (Exception ex) {
            RspModel rsp = new RspModel();
            rsp.setCode(500);
            rsp.setMessage(ex.getMessage());
            return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @RequestMapping(value = "/listCurrentCourse", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<RspModel> finUserCourses(@RequestParam String mentorname) {

        try {

            List<CourseRateDto> mentorCourses = service.findCurrentMentorCourse(mentorname);

            if (mentorCourses.size() > 0) {

                RspModel rsp = new RspModel();
                rsp.setCode(200);
                rsp.setMessage("Found Courses");
                rsp.setData(mentorCourses);
                return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);

            } else {
                RspModel rsp = new RspModel();
                rsp.setCode(404);
                rsp.setMessage("No Found Courses");
                return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);
            }

        } catch (Exception ex) {
            RspModel rsp = new RspModel();
            rsp.setCode(500);
            rsp.setMessage(ex.getMessage());
            return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @RequestMapping(value = "/listavailablecourse", method = RequestMethod.GET, produces = "application/json")
     public ResponseEntity<RspModel> finMentorAvailableCourses( @RequestParam String mentorname) {

        try {

            List<CourseRateDto> coursementors = service.findMentorAvailableCourse(mentorname);

            if (coursementors.size() > 0) {

                RspModel rsp = new RspModel();
                rsp.setCode(200);
                rsp.setMessage("Found Courses");
                rsp.setData(coursementors);
                return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);

            } else {
                RspModel rsp = new RspModel();
                rsp.setCode(404);
                rsp.setMessage("No Found Courses");
                return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);
            }

        } catch (Exception ex) {
            RspModel rsp = new RspModel();
            rsp.setCode(500);
            rsp.setMessage(ex.getMessage());
            return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
