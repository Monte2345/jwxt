package com.example.jwxt.mapper;

import com.example.jwxt.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {
    @Insert({
        "insert into teacher (id, tno, ",
        "name, pwd)",
        "values (#{id,jdbcType=INTEGER}, #{tno,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{pwd,jdbcType=INTEGER})"
    })
    int insert(Teacher record);

    @InsertProvider(type=TeacherSqlProvider.class, method="insertSelective")
    int insertSelective(Teacher record);
}