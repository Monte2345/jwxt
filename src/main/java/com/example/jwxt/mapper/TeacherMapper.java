package com.example.jwxt.mapper;

import com.example.jwxt.entity.*;
import com.example.jwxt.support.returnEntity.ServerReturnObject;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherMapper {
    @Delete({
        "delete from teacher",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into teacher (id, tno, ",
        "name, pwd, identity)",
        "values (#{id,jdbcType=INTEGER}, #{tno,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{pwd,jdbcType=VARCHAR}, #{identity,jdbcType=VARCHAR})"
    })
    int insert(Teacher record);

    @InsertProvider(type=TeacherSqlProvider.class, method="insertSelective")
    int insertSelective(Teacher record);

    @Select({
        "select",
        "id, tno, name, pwd, identity",
        "from teacher",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tno", property="tno", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="identity", property="identity", jdbcType=JdbcType.VARCHAR)
    })
    Teacher selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TeacherSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Teacher record);

    @Update({
        "update teacher",
        "set tno = #{tno,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "pwd = #{pwd,jdbcType=VARCHAR},",
          "identity = #{identity,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Teacher record);

    @Select({
            "select",
            "id",
            "from teacher",
            "where tno = #{tno,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER)
    })
    Integer selectPrimaryKeyByTno(Integer tno);

    @Select({
            "select *",
            "from c_n",
    })
    List<CN> getCourseNum();

    @Select({
            "select *",
            "from class_schedule",
    })
    List<ClassSchedule> getClassSchedule();

    @Select({
            "select *",
            "from teacher_schedule",
            "where tno = #{tno,jdbcType=INTEGER}  "
    })
    List<Map<String, Object>> getSchedule(Integer tno);

    @Select({
            "select student.sno,student.name,student.student_class,grade",
            "from student_class,student",
            "where curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}  and",
            "student_class.sno=student.sno"
    })
    List<Map<String, Object>> getStudentsByClass(String curriculaVariable);

    @Update({"<script>"  +
            "<foreach collection='list' item='item' index='index'  separator=',' > " +
            "update student_class set grade= #{item.grade} " +
            "where sno = #{item.sno} and curricula_variable = #{item.curriculaVariable} " +
            "</foreach>" +
            "</script>"})
    void batchGradeUpdate(@Param("list")List<StudentClass> list);

    @Select({
            "select *",
            "from student",
            "order by student_class"
    })
    List<Student> getAllStudents();

    @Select({
            "select *",
            "from teacher",
            "order by identity"
    })
    List<Teacher> getAllTeachers();

    @Select({
            "select *",
            "from course",
            "order by credit"
    })
    List<Course> getAllCourses();

    @Update({
            "update course_class",
            "set time_period = #{timePeriod,jdbcType=VARCHAR}",
            "where curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}"
    })
    void courseTimeUpdate(String curriculaVariable, String timePeriod);

    @Update({
            "update teacher_class",
            "set time_period = #{timePeriod,jdbcType=VARCHAR}",
            "where curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}"
    })
    void teacherTimeUpdate(String curriculaVariable, String timePeriod);
}