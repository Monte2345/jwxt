package com.example.jwxt.mapper;

import com.example.jwxt.entity.ClassSchedule;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface ClassScheduleMapper {
    @Insert({
        "insert into class_schedule (gno, tno, ",
        "cno, type, credit)",
        "values (#{gno,jdbcType=INTEGER}, #{tno,jdbcType=INTEGER}, ",
        "#{cno,jdbcType=INTEGER}, #{type,jdbcType=VARCHAR}, #{credit,jdbcType=TINYINT})"
    })
    int insert(ClassSchedule record);

    @InsertProvider(type=ClassScheduleSqlProvider.class, method="insertSelective")
    int insertSelective(ClassSchedule record);
}