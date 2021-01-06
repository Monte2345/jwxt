package com.example.jwxt.controller.Impl;

import com.example.jwxt.controller.TeacherController;
import com.example.jwxt.entity.Teacher;

import com.example.jwxt.service.TeacherService;
import com.example.jwxt.support.returnEntity.ServerReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class TeacherControllerImpl implements TeacherController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckControllerImpl.class);

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/teacherLogin")
    public ServerReturnObject login(HttpServletRequest request, Teacher teacher, String check) throws Exception {
        HttpSession session = request.getSession(true);
        if(check==null||check.equals(""))
        {
            return ServerReturnObject.createErrorByMessage("验证码为空！");
        }
        String code = session.getAttribute("VerifyCode").toString();
        LOGGER.info(check);
        if (code.equalsIgnoreCase(check)) {
            return teacherService.login(teacher);
        }else {
            return ServerReturnObject.createErrorByMessage("验证码错误！");
        }
    }
}
