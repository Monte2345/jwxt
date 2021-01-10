package com.example.jwxt.service;

import com.example.jwxt.entity.Student;
import com.example.jwxt.support.returnEntity.ServerReturnObject;

public interface StudentService {
    ServerReturnObject login(Student student) throws Exception;

    ServerReturnObject getGrade(Integer sno);

    ServerReturnObject getGPA(Integer sno);

    ServerReturnObject getRank(Integer sno);
}
