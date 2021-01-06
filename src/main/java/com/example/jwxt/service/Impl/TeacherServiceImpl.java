package com.example.jwxt.service.Impl;

import com.example.jwxt.entity.Student;
import com.example.jwxt.entity.Teacher;
import com.example.jwxt.mapper.TeacherMapper;
import com.example.jwxt.service.TeacherService;
import com.example.jwxt.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public ServerReturnObject login(Teacher teacher) throws Exception {
        if(teacher.getTno()==null)
        {
            return ServerReturnObject.createErrorByMessage("教工号为空！");
        }
        if(teacher.getPwd()==null)
        {
            return ServerReturnObject.createErrorByMessage("密码为空！");
        }
        if(teacher.getIdentity()==null)
        {
            return ServerReturnObject.createErrorByMessage("请选择身份！");
        }
        Integer id = teacherMapper.selectPrimaryKeyByTno(teacher.getTno());
        if(id==null)
        {
            return ServerReturnObject.createErrorByMessage("教工号不存在！");
        }
        Teacher rteacher = teacherMapper.selectByPrimaryKey(id);
        if(!teacher.getPwd().equals(rteacher.getPwd()))
        {
            return ServerReturnObject.createErrorByMessage("密码错误！");
        }
        else
        {
            //登录成功 返回教师信息
            return ServerReturnObject.createSuccessByMessageAndData("登录成功！",rteacher);
        }
    }
}
