package com.example.jwxt.mapper;

import com.example.jwxt.entity.TeacherCourse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TeacherCourseMapper {
    @Delete({
        "delete from teacher_course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into teacher_course (id, tno, ",
        "time_period, curricula_variable)",
        "values (#{id,jdbcType=INTEGER}, #{tno,jdbcType=INTEGER}, ",
        "#{timePeriod,jdbcType=VARCHAR}, #{curriculaVariable,jdbcType=VARCHAR})"
    })
    int insert(TeacherCourse record);

    @InsertProvider(type=TeacherCourseSqlProvider.class, method="insertSelective")
    int insertSelective(TeacherCourse record);

    @Select({
        "select",
        "id, tno, time_period, curricula_variable",
        "from teacher_course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tno", property="tno", jdbcType=JdbcType.INTEGER),
        @Result(column="time_period", property="timePeriod", jdbcType=JdbcType.VARCHAR),
        @Result(column="curricula_variable", property="curriculaVariable", jdbcType=JdbcType.VARCHAR)
    })
    TeacherCourse selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TeacherCourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TeacherCourse record);

    @Update({
        "update teacher_course",
        "set tno = #{tno,jdbcType=INTEGER},",
          "time_period = #{timePeriod,jdbcType=VARCHAR},",
          "curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TeacherCourse record);
}