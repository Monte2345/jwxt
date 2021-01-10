package com.example.jwxt.mapper;

import com.example.jwxt.entity.TeacherClass;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface TeacherClassMapper {
    @Delete({
        "delete from teacher_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into teacher_class (id, tno, ",
        "time_period, curricula_variable)",
        "values (#{id,jdbcType=INTEGER}, #{tno,jdbcType=INTEGER}, ",
        "#{timePeriod,jdbcType=VARCHAR}, #{curriculaVariable,jdbcType=VARCHAR})"
    })
    int insert(TeacherClass record);

    @InsertProvider(type=TeacherClassSqlProvider.class, method="insertSelective")
    int insertSelective(TeacherClass record);

    @Select({
        "select",
        "id, tno, time_period, curricula_variable",
        "from teacher_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tno", property="tno", jdbcType=JdbcType.INTEGER),
        @Result(column="time_period", property="timePeriod", jdbcType=JdbcType.VARCHAR),
        @Result(column="curricula_variable", property="curriculaVariable", jdbcType=JdbcType.VARCHAR)
    })
    TeacherClass selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TeacherClassSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TeacherClass record);

    @Update({
        "update teacher_class",
        "set tno = #{tno,jdbcType=INTEGER},",
          "time_period = #{timePeriod,jdbcType=VARCHAR},",
          "curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TeacherClass record);

    @Delete({
            "delete from teacher_class",
            "where 1=1"
    })
    int deleteAll();
}