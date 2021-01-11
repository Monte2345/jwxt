package com.example.jwxt.controller;

import com.example.jwxt.entity.StudentClass;
import com.example.jwxt.entity.StudentClasses;
import com.example.jwxt.entity.Teacher;
import com.example.jwxt.support.returnEntity.ServerReturnObject;
import org.apache.tomcat.util.json.ParseException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TeacherController {
    ServerReturnObject login(HttpServletRequest request, Teacher teacher, String check) throws Exception;

    ServerReturnObject arrangingClass();

    ServerReturnObject getSchedule(Integer tno);

    ServerReturnObject getStudentsByClass(String curriculaVariable);

//    ServerReturnObject batchGradeUpdate(List<StudentClass> studentClasses) ;

    ServerReturnObject singleGradeUpdate(StudentClass studentClass);

    ServerReturnObject getAllStudents();

    ServerReturnObject getAllTeachers();

    ServerReturnObject getAllCourses();

    ServerReturnObject singleTimeUpdate(String curriculaVariable,String timePeriod);

    ServerReturnObject AllCourseClassView();

}
