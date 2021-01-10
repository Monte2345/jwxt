package com.example.jwxt.controller.Impl;

import com.example.jwxt.controller.StudentController;
import com.example.jwxt.entity.Student;
import com.example.jwxt.service.StudentService;
import com.example.jwxt.support.returnEntity.ServerReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class StudentControllerImpl implements StudentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckControllerImpl.class);

    @Autowired
    private StudentService studentService;

    @PostMapping("/studentLogin")
    public ServerReturnObject login(HttpServletRequest request, Student student,String check) throws Exception {
        HttpSession session = request.getSession(true);
        if(check==null||check.equals(""))
        {
            return ServerReturnObject.createErrorByMessage("验证码为空！");
        }
        String code = session.getAttribute("VerifyCode").toString();

        LOGGER.info(check);
        if (code.equalsIgnoreCase(check)) {
            return studentService.login(student);
        }else {
            return ServerReturnObject.createErrorByMessage("验证码错误！");

        }


    }

    @RequestMapping("/getGrade")
    public ServerReturnObject getGrade(Integer sno) {
        return studentService.getGrade(sno);
    }

    @RequestMapping("/getGPA")
    public ServerReturnObject getGPA(Integer sno) {
        return studentService.getGPA(sno);
    }

    @RequestMapping("/getRank")
    public ServerReturnObject getRank(Integer sno) {
        return studentService.getRank(sno);
    }
}
