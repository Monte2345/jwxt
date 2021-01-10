package com.example.jwxt.controller.Impl;

import com.example.jwxt.controller.StudentClassController;
import com.example.jwxt.service.CourseClassService;
import com.example.jwxt.service.StudentClassService;
import com.example.jwxt.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentClassControllerImpl implements StudentClassController {
    @Autowired
    private StudentClassService studentClassService;

    @Autowired
    private CourseClassService courseClassService;

    @RequestMapping("/studentChooseClass")
    public ServerReturnObject insert(Integer sno, String curriculaVariable) {
        if(!studentClassService.judgeCurricula(sno,curriculaVariable)) {
            return ServerReturnObject.createErrorByMessage("已选课！");

        }
        Integer cno = courseClassService.findCno(curriculaVariable);
        if(!studentClassService.judgeCno(sno,cno))
        {
            return ServerReturnObject.createErrorByMessage("已选课！");
        }
        else {
            return studentClassService.insert(sno, curriculaVariable);
        }
    }



    @RequestMapping("/judgeCno")
    public ServerReturnObject judgeCno(Integer sno, Integer cno) {
        if(!studentClassService.judgeCno(sno,cno))
        {
            return ServerReturnObject.createErrorByMessage("已选课");
        }
        return ServerReturnObject.createSuccessByMessage("未选课");
    }

    @RequestMapping("/judgeCurricula")
    public ServerReturnObject judgeCurricula(Integer sno, String curriculaVariable) {
        if(!studentClassService.judgeCurricula(sno,curriculaVariable))
        {
            return ServerReturnObject.createErrorByMessage("已选课");
        }
        return ServerReturnObject.createSuccessByMessage("未选课");
    }

    @RequestMapping("/getStudentSchedule")
    public ServerReturnObject getSchedule(Integer sno) {
        return studentClassService.getSchedule(sno);
    }

    @RequestMapping("/studentDropClass")
    public ServerReturnObject delete(Integer sno, String curriculaVariable) {
        return studentClassService.delete(sno, curriculaVariable);

    }


}
