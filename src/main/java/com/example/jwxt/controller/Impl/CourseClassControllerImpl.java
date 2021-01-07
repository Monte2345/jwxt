package com.example.jwxt.controller.Impl;

import com.example.jwxt.controller.CourseClassController;
import com.example.jwxt.service.CourseClassService;
import com.example.jwxt.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseClassControllerImpl implements CourseClassController {
    @Autowired
    private CourseClassService courseClassService;

    @RequestMapping("/courseClassView")
    public ServerReturnObject courseClassView() {
        return courseClassService.courseClassView();
    }
}
