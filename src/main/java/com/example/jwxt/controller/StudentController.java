package com.example.jwxt.controller;

import com.example.jwxt.entity.Student;
import com.example.jwxt.support.returnEntity.ServerReturnObject;

import javax.servlet.http.HttpServletRequest;

public interface StudentController {
    ServerReturnObject login(HttpServletRequest request, Student student,String check) throws Exception;
}
