package com.example.jwxt.service.Impl;

import com.example.jwxt.entity.Student;
import com.example.jwxt.mapper.StudentMapper;
import com.example.jwxt.service.StudentService;
import com.example.jwxt.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public ServerReturnObject login(Student student) throws Exception {
        if(student.getSno()==null)
        {
            return ServerReturnObject.createErrorByMessage("学号为空！");
        }
        if(student.getPwd()==null)
        {
            return ServerReturnObject.createErrorByMessage("密码为空！");
        }
        Integer id = studentMapper.selectPrimaryKeyBySno(student.getSno());
        if(id==null)
        {
            return ServerReturnObject.createErrorByMessage("学号不存在！");
        }
        Student rstudent = studentMapper.selectByPrimaryKey(id);
        if(!student.getPwd().equals(rstudent.getPwd()))
        {
            return ServerReturnObject.createErrorByMessage("密码错误！");
        }
        else
        {
            //登录成功 返回学生信息
            return ServerReturnObject.createSuccessByMessageAndData("登录成功！",rstudent);
        }

    }

    @Override
    public ServerReturnObject getGrade(Integer sno) {
        return ServerReturnObject.createSuccessByMessageAndData("课程成绩",studentMapper.getGrade(sno));
    }

    @Override
    public ServerReturnObject getGPA(Integer sno) {

        return ServerReturnObject.createSuccessByMessageAndData("gpa",studentMapper.getGPA(sno));
    }

    @Override
    public ServerReturnObject getRank(Integer sno) {
        return ServerReturnObject.createSuccessByMessageAndData("绩点排名",studentMapper.getRank(sno));
    }
}
