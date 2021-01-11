package com.example.jwxt.service;

import com.example.jwxt.support.returnEntity.ServerReturnObject;

public interface CourseClassService {
    ServerReturnObject courseClassView();

    Integer findCno(String curriculaVariable);

    ServerReturnObject AllcourseClassView();
}
