package com.ibm.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-05 17:02
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "";
    }
}
