package com.example.jwxt.controller;

import com.example.jwxt.entity.Teacher;
import com.example.jwxt.support.returnEntity.ServerReturnObject;

import javax.servlet.http.HttpServletRequest;

public interface TeacherController {
    ServerReturnObject login(HttpServletRequest request, Teacher teacher, String check) throws Exception;

    ServerReturnObject arrangingClass();
}
