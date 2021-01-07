package com.example.jwxt.service.Impl;

import com.example.jwxt.entity.CourseClass;
import com.example.jwxt.entity.StudentClass;
import com.example.jwxt.mapper.CourseClassMapper;
import com.example.jwxt.mapper.StudentClassMapper;
import com.example.jwxt.service.StudentClassService;
import com.example.jwxt.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class StudentClassServiceImpl implements StudentClassService {
    @Autowired
    private StudentClassMapper studentClassMapper;
    @Autowired
    private CourseClassMapper courseClassMapper;
    @Override
    public ServerReturnObject insert(Integer sno, String curriculaVariable) {
        StudentClass studentClass = new StudentClass();
        studentClass.setSno(sno);
        studentClass.setCurriculaVariable(curriculaVariable);
        studentClass.setGrade((byte)0);
        studentClassMapper.insert(studentClass);
        //更新选课人数
        Integer enrollment = studentClassMapper.getEnrollment(curriculaVariable);
        Integer id = courseClassMapper.findIdByCurricula(curriculaVariable);
        CourseClass courseClass  = new CourseClass();
        courseClass.setId(id);
        courseClass.setEnrollment(enrollment);
        courseClassMapper.updateByPrimaryKeySelective(courseClass);
        return ServerReturnObject.createSuccessByMessage("选课成功！");
    }

    @Override
    public boolean judgeCurricula(Integer sno, String curriculaVariable) {
        List<StudentClass> studentClassList = studentClassMapper.findBySnoAndCurricula(sno,curriculaVariable);
        if(studentClassList.size()>0) {
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public boolean judgeCno(Integer sno, Integer cno) {
        List<Map<String, Object>> list = studentClassMapper.judgeCno(sno,cno);
        if(list.size()>0)
            return false;

        else{
            return true;

        }
    }

    @Override
    public ServerReturnObject getSchedule(Integer sno) {
        return ServerReturnObject.createSuccessByMessageAndData("学生个人课表",studentClassMapper.getSchedule(sno));
    }

    @Override
    public ServerReturnObject delete(Integer sno, String curriculaVariable) {
        Integer id = studentClassMapper.selectIdBySnoAndCurriculaVariable(sno,curriculaVariable);
        if(id==null){
            return ServerReturnObject.createErrorByMessage("选课记录不存在！");
        }
        studentClassMapper.deleteByPrimaryKey(id);
        //更新选课人数
        Integer enrollment = studentClassMapper.getEnrollment(curriculaVariable);
        Integer ccid = courseClassMapper.findIdByCurricula(curriculaVariable);
        CourseClass courseClass  = new CourseClass();
        courseClass.setId(ccid);
        courseClass.setEnrollment(enrollment);
        courseClassMapper.updateByPrimaryKeySelective(courseClass);
        return ServerReturnObject.createSuccessByMessage("删除成功！");
    }
}
