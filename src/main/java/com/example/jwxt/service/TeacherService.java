package com.example.jwxt.service;

import com.example.jwxt.entity.StudentClass;
import com.example.jwxt.entity.Teacher;
import com.example.jwxt.support.returnEntity.ServerReturnObject;

import java.util.List;

public interface TeacherService {
    ServerReturnObject login(Teacher teacher) throws Exception;

    ServerReturnObject arrangingClass();

    ServerReturnObject getSchedule(Integer tno);

    ServerReturnObject getStudentsByClass(String curriculaVariable);

    ServerReturnObject batchGradeUpdate(List<StudentClass> students);

    ServerReturnObject getAllStudents();

    ServerReturnObject getAllTeachers();

    ServerReturnObject getAllCourses();

    ServerReturnObject singleTimeUpdate(String curriculaVariable, String timePeriod);
}
