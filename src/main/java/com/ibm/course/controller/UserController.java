package com.ibm.course.controller;

import com.ibm.course.dto.CourseRateDto;
import com.ibm.course.dto.CourseUserDto;
import com.ibm.course.dto.RspModel;
import com.ibm.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-06 15:27
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private CourseService service;

    @RequestMapping(value = "/searchcourse", method = RequestMethod.GET, produces = "application/json")

    public ResponseEntity<RspModel> searchCourses() {

        try {

            List<CourseRateDto> mentorcourses = service.searchCourses();

            if (mentorcourses.size() > 0) {

                RspModel rsp = new RspModel();
                rsp.setCode(200);
                rsp.setMessage("Found Courses");
                rsp.setData(mentorcourses);
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

    @RequestMapping(value = "/book", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<RspModel> bookCourses( @RequestBody CourseUserDto bookcourse) {

        try {

            service.bookCourse(bookcourse);
            RspModel rsp = new RspModel();
            rsp.setCode(200);
            rsp.setMessage("Book Sucessful");
            return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);

        } catch (Exception ex) {
            RspModel rsp = new RspModel();
            rsp.setCode(500);
            rsp.setMessage(ex.getMessage());
            return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
   public ResponseEntity<RspModel> finUserCourses( @RequestParam String username) {

        try {

            List<CourseRateDto> usercourses = service.searchBookedCourses(username);

            if (usercourses.size() > 0) {
                RspModel rsp = new RspModel();
                rsp.setCode(200);
                rsp.setMessage("Found Courses");
                rsp.setData(usercourses);
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
   public ResponseEntity<RspModel> finUserCompletedCourses( @RequestParam String username) {

        try {

            List<CourseRateDto> usercompletedcourses = service.searchCompletedBookedCourses(username);

            if (usercompletedcourses.size() > 0) {

                RspModel rsp = new RspModel();
                rsp.setCode(200);
                rsp.setMessage("Found Courses");
                rsp.setData(usercompletedcourses);
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
