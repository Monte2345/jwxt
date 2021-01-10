package com.example.jwxt.service.Impl;

import com.example.jwxt.entity.*;
import com.example.jwxt.mapper.CourseClassMapper;
import com.example.jwxt.mapper.TeacherClassMapper;
import com.example.jwxt.mapper.TeacherMapper;
import com.example.jwxt.service.TeacherService;
import com.example.jwxt.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherClassMapper teacherClassMapper;

    @Autowired
    private CourseClassMapper courseClassMapper;




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

    @Override
    public ServerReturnObject arrangingClass() {
        //删除已有的排课记录
        teacherClassMapper.deleteAll();
        courseClassMapper.deleteAll();
        String []weekdays={"Mon","Tue","Wed","Thu","Fri"};
        String []time = {"1-2","3-4","5-6","7-8","9-11"};
        List<CN> cn = teacherMapper.getCourseNum();
        List<ClassSchedule> classSchedules = teacherMapper.getClassSchedule();
        List<ClassIndividual> classIndividuals = new ArrayList<ClassIndividual>();

        String curriculaVariable;
        int index = 0;
        for(int i = 0;i<cn.size();i++)
            for(int j = 0;j< cn.get(i).getNum();j++)
            {
                if(index<classSchedules.size())//&&classSchedules.get(index).getType().equals("专业选修"))
                {
                    ClassIndividual classIndividual = new ClassIndividual();
                    classIndividual.setCno(classSchedules.get(index).getCno());
                    classIndividual.setTno(classSchedules.get(index).getTno());
                    classIndividual.setCredit(classSchedules.get(index).getCredit());
                    classIndividual.setCurriculaVariable(classSchedules.get(index).getCno()+"-"+(j+1));

                    classIndividuals .add(classIndividual);
                    if(classSchedules.get(index).getCredit()==4)//4学分要加多一个对象
                         classIndividuals .add(classIndividual);//不需要修改数据

                }
                index++;
            }
        List<Schedule>schedules=new ArrayList<Schedule>();;
        for(int i = 0;i<25;i++)
        {
            Schedule schedule = new Schedule();
            schedules.add(schedule);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        Random r = new Random();
        int rand1 = 0;
        int rand2 = 0;
        List<String> curriculaVariables;
        List<Integer>tnoList;
        List<Integer>cnoList;
        int num = classIndividuals.size();
        for(int key = 0;key<classIndividuals.size();key++) {
            ClassIndividual individual = classIndividuals.get(key);

            boolean hasInserted = false;//判断是否已经插入
            while(!hasInserted){
                boolean flag = true;//判断位置能不能插入
                if(individual.getCredit()==3)
                {
                    rand2 = r.nextInt(5);
                    rand1 = (rand2+1)*5-1;
                }
                else {
                    rand1 = r.nextInt(25);
                }
                if (map.get(rand1) == null) {//避免重复判断同一个位置
                    map.put(rand1, 0);
                    tnoList = schedules.get(rand1).getTnoList();
                    cnoList = schedules.get(rand1).getCnoList();
                    curriculaVariables = schedules.get(rand1).getCurriculaVariables();

                    for (int t = 0; t < tnoList.size(); t++) {
                        if (tnoList.get(t).intValue() == individual.getTno().intValue()) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                        for (int c = 0; c < cnoList.size(); c++) {
                            Integer cno1 = cnoList.get(c);
                            Integer cno2 = individual.getCno();
                            if (cno1.intValue() != cno2.intValue()) {
                                flag = false;
                                break;
                            }
                        }
                    if (flag) {
                        //插入
                        if ((rand1+1)%5 == 0) {//如果是晚课
                            if (individual.getCredit() == 3) {
                                tnoList.add(individual.getTno());
                                cnoList.add(individual.getCno());
                                curriculaVariables.add(individual.getCurriculaVariable());
                                schedules.get(rand1).setCnoList(cnoList);
                                schedules.get(rand1).setCurriculaVariables(curriculaVariables);
                                schedules.get(rand1).setTnoList(tnoList);
                                num--;
                                hasInserted = true;
                            }
                        } else {
                            if(individual.getCredit()!=3) {
                                tnoList.add(individual.getTno());
                                cnoList.add(individual.getCno());
                                curriculaVariables.add(individual.getCurriculaVariable());
                                schedules.get(rand1).setCnoList(cnoList);
                                schedules.get(rand1).setCurriculaVariables(curriculaVariables);
                                schedules.get(rand1).setTnoList(tnoList);
                                num--;
                                hasInserted = true;
                            }
                        }
                    }
                }

            }


            map.clear();
        }
        List<CourseClass>courseClasses = new ArrayList<CourseClass>();
        List<TeacherClass>teacherClasses = new ArrayList<TeacherClass>();
        if(num!=0)
        {
            //没有分配完
        }else{//将schedules转换

            Map<String, Integer> rmap = new HashMap<String, Integer>();
            int n = 0;
            for(int i = 0;i<schedules.size();i++)
            {
                int size = schedules.get(i).getTnoList().size();

                if(size!=0)
                {
                    for(int j = 0;j<size;j++) {
                        Schedule schedule = schedules.get(i);
                        CourseClass courseClass = new CourseClass();
                        TeacherClass teacherClass = new TeacherClass();
                        if(rmap.get(schedule.getCurriculaVariables().get(j))!=null)//4学分班号重复
                        {
                            Integer rindex = rmap.get(schedule.getCurriculaVariables().get(j));
                            String timePeriod =  weekdays[i / 5] + "." +courseClasses.get(rindex).getTimePeriod()
                                   +"."+ time[i % 5];
                            courseClasses.get(rindex).setTimePeriod(timePeriod);
                            teacherClasses.get(rindex).setTimePeriod(timePeriod);

                        }
                        else {

                            teacherClass.setCurriculaVariable(schedule.getCurriculaVariables().get(j));
                            String timePeriod = weekdays[i / 5] + "|" + time[i % 5];
                            teacherClass.setTimePeriod(timePeriod);
                            teacherClass.setTno(schedule.getTnoList().get(j));

                            courseClass.setEnrollment(0);
                            courseClass.setCapacity(100);
                            courseClass.setCno(schedule.getCnoList().get(j));
                            courseClass.setCurriculaVariable(schedule.getCurriculaVariables().get(j));
                            courseClass.setTimePeriod(timePeriod);

                            teacherClasses.add(teacherClass);
                            courseClasses.add(courseClass);
                            rmap.put(courseClass.getCurriculaVariable(), n);
                            n++;
                        }
                    }
                }
            }

        }

        for(int i = 0;i<courseClasses.size();i++)
        {
            courseClassMapper.insert(courseClasses.get(i));
        }
        for(int i = 0;i<teacherClasses.size();i++)
        {
            teacherClassMapper.insert(teacherClasses.get(i));
        }
        index = 0;
        return null;
    }

    @Override
    public ServerReturnObject getSchedule(Integer tno) {
        return ServerReturnObject.createSuccessByMessageAndData("任课安排",teacherMapper.getSchedule(tno));
    }

    @Override
    public ServerReturnObject getStudentsByClass(String curriculaVariable) {
        return ServerReturnObject.createSuccessByMessageAndData("学生名单",teacherMapper.getStudentsByClass(curriculaVariable));
    }

    @Override
    public ServerReturnObject batchGradeUpdate(List<StudentClass> students) {
        teacherMapper.batchGradeUpdate(students);
        //students.get(0).grade;
        return ServerReturnObject.createSuccessByMessage("学生成绩修改");
    }
}
