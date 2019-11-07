package com.ibm.course.controller;

import com.ibm.course.dto.CourseRateDto;
import com.ibm.course.dto.RspModel;
import com.ibm.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-05 17:04
 */
@RestController
@RequestMapping("/api/v1/mentor")
public class MentorController {
    @Autowired
    private CourseService service;
    @RequestMapping(value = "/listAll", method = RequestMethod.GET, produces = "application/json")
   public ResponseEntity<RspModel> findCourses() {

        try {

            List<CourseRateDto> courses = service.listAll();

            if (courses.size() > 0) {

                RspModel rsp = new RspModel();
                rsp.setCode(200);
                rsp.setMessage("Found Courses");
                rsp.setData(courses);
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

    @RequestMapping(value = "/listdone", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<RspModel> findCompletedTranings(@RequestParam String mentorname) {

        try {

            List<CourseRateDto> coursementors = service.findCompletedTranings(mentorname);

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
