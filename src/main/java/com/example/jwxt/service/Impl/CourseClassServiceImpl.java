package com.example.jwxt.service.Impl;

import com.example.jwxt.mapper.CourseClassMapper;
import com.example.jwxt.service.CourseClassService;
import com.example.jwxt.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseClassServiceImpl implements CourseClassService {
    @Autowired
    private CourseClassMapper courseClassMapper;


    @Override
    public ServerReturnObject courseClassView() {

        return ServerReturnObject.createSuccessByMessageAndData("自主选课",courseClassMapper.courseClassView());
    }

    @Override
    public Integer findCno(String curriculaVariable) {
        return courseClassMapper.findCnoByCurricula(curriculaVariable);
    }
}
