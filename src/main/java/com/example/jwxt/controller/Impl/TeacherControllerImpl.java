package com.example.jwxt.controller.Impl;

import com.example.jwxt.controller.TeacherController;
import com.example.jwxt.entity.StudentClass;
import com.example.jwxt.entity.StudentClasses;
import com.example.jwxt.entity.Teacher;

import com.example.jwxt.service.TeacherService;
import com.example.jwxt.support.returnEntity.ServerReturnObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
class User {
    private String name;
    private String pwd;
    //省略getter/setter
}
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

    @RequestMapping("/arrangingClass")
    public ServerReturnObject arrangingClass() {
        return teacherService.arrangingClass();
    }

    @RequestMapping("getTeacherSchedule")
    public ServerReturnObject getSchedule(Integer tno) {
        return teacherService.getSchedule(tno);
    }

    @RequestMapping("getStudentsByClass")
    public ServerReturnObject getStudentsByClass(String curriculaVariable) {
        return teacherService.getStudentsByClass(curriculaVariable);
    }

    @RequestMapping("batchGradeUpdate")
    public ServerReturnObject batchGradeUpdate(List<StudentClass> studentClasses)  {

//        for(int i = 0;i<studentClasses.length;i++)
//        {
//            list.add(studentClasses[i]);
//        }
        return teacherService.batchGradeUpdate(studentClasses);
    }

    @RequestMapping("singleGradeUpdate")
    public ServerReturnObject singleGradeUpdate(StudentClass studentClass) {
        List<StudentClass> studentClasses = new ArrayList<>();
        studentClasses.add(studentClass);
        return teacherService.batchGradeUpdate(studentClasses);
    }

    @RequestMapping("/getAllStudents")
    public ServerReturnObject getAllStudents() {
        return teacherService.getAllStudents();
    }

    @RequestMapping("/getAllTeachers")
    public ServerReturnObject getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @RequestMapping("/getAllCourses")
    public ServerReturnObject getAllCourses() {
        return teacherService.getAllCourses();
    }

    @RequestMapping("singleTimeUpdate")
    public ServerReturnObject singleTimeUpdate(String curriculaVariable, String timePeriod) {
        return teacherService.singleTimeUpdate(curriculaVariable,timePeriod);
    }

    @RequestMapping("saveUsers")
    public void saveUsers(@RequestBody List<User> userList) {

    }


}
