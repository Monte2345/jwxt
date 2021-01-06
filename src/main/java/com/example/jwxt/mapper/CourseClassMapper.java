package com.example.jwxt.mapper;

import com.example.jwxt.entity.CourseClass;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface CourseClassMapper {
    @Insert({
        "insert into course_class (id, cno, ",
        "curricula_variable, time_period)",
        "values (#{id,jdbcType=INTEGER}, #{cno,jdbcType=INTEGER}, ",
        "#{curriculaVariable,jdbcType=VARCHAR}, #{timePeriod,jdbcType=VARCHAR})"
    })
    int insert(CourseClass record);

    @InsertProvider(type=CourseClassSqlProvider.class, method="insertSelective")
    int insertSelective(CourseClass record);
}