package com.example.jwxt.service;

import com.example.jwxt.entity.Teacher;
import com.example.jwxt.support.returnEntity.ServerReturnObject;

public interface TeacherService {
    ServerReturnObject login(Teacher teacher) throws Exception;

    ServerReturnObject arrangingClass();
}
