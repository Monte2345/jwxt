package com.example.jwxt.mapper;

import com.example.jwxt.entity.CC;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface CCMapper {
    @Insert({
        "insert into c_c (courseName, courseCno, ",
        "type, credit, curriculaVariable, ",
        "timePeriod, teacherName, ",
        "tno, capacity, enrollment)",
        "values (#{coursename,jdbcType=VARCHAR}, #{coursecno,jdbcType=INTEGER}, ",
        "#{type,jdbcType=VARCHAR}, #{credit,jdbcType=TINYINT}, #{curriculavariable,jdbcType=VARCHAR}, ",
        "#{timeperiod,jdbcType=VARCHAR}, #{teachername,jdbcType=INTEGER}, ",
        "#{tno,jdbcType=VARCHAR}, #{capacity,jdbcType=INTEGER}, #{enrollment,jdbcType=INTEGER})"
    })
    int insert(CC record);

    @InsertProvider(type=CCSqlProvider.class, method="insertSelective")
    int insertSelective(CC record);
}