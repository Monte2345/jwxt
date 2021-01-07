package com.example.jwxt.mapper;

import com.example.jwxt.entity.CourseClass;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;
@Mapper
public interface CourseClassMapper {
    @Delete({
        "delete from course_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into course_class (id, cno, ",
        "curricula_variable, time_period, ",
        "capacity, enrollment)",
        "values (#{id,jdbcType=INTEGER}, #{cno,jdbcType=INTEGER}, ",
        "#{curriculaVariable,jdbcType=VARCHAR}, #{timePeriod,jdbcType=VARCHAR}, ",
        "#{capacity,jdbcType=INTEGER}, #{enrollment,jdbcType=INTEGER})"
    })
    int insert(CourseClass record);

    @InsertProvider(type=CourseClassSqlProvider.class, method="insertSelective")
    int insertSelective(CourseClass record);

    @Select({
        "select",
        "id, cno, curricula_variable, time_period, capacity, enrollment",
        "from course_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cno", property="cno", jdbcType=JdbcType.INTEGER),
        @Result(column="curricula_variable", property="curriculaVariable", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_period", property="timePeriod", jdbcType=JdbcType.VARCHAR),
        @Result(column="capacity", property="capacity", jdbcType=JdbcType.INTEGER),
        @Result(column="enrollment", property="enrollment", jdbcType=JdbcType.INTEGER)
    })
    CourseClass selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CourseClassSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CourseClass record);

    @Update({
        "update course_class",
        "set cno = #{cno,jdbcType=INTEGER},",
          "curricula_variable = #{curriculaVariable,jdbcType=VARCHAR},",
          "time_period = #{timePeriod,jdbcType=VARCHAR},",
          "capacity = #{capacity,jdbcType=INTEGER},",
          "enrollment = #{enrollment,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CourseClass record);

    @Select({
            "select *",
            "from c_c"
    })
    List<Map<String, Object>> courseClassView();

    @Select({
            "select cno",
            "from course_class " +
                    "where curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}"
    })
    Integer findCnoByCurricula(String curriculaVariable);

    @Select({
            "select id",
            "from course_class " +
                    "where curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}"
    })
    Integer findIdByCurricula(String curriculaVariable);
}