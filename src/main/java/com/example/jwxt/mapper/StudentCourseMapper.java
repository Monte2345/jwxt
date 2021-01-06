package com.example.jwxt.mapper;

import com.example.jwxt.entity.StudentCourse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface StudentCourseMapper {
    @Delete({
        "delete from student_course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into student_course (id, sno, ",
        "grade, curricula_variable)",
        "values (#{id,jdbcType=INTEGER}, #{sno,jdbcType=INTEGER}, ",
        "#{grade,jdbcType=TINYINT}, #{curriculaVariable,jdbcType=VARCHAR})"
    })
    int insert(StudentCourse record);

    @InsertProvider(type=StudentCourseSqlProvider.class, method="insertSelective")
    int insertSelective(StudentCourse record);

    @Select({
        "select",
        "id, sno, grade, curricula_variable",
        "from student_course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sno", property="sno", jdbcType=JdbcType.INTEGER),
        @Result(column="grade", property="grade", jdbcType=JdbcType.TINYINT),
        @Result(column="curricula_variable", property="curriculaVariable", jdbcType=JdbcType.VARCHAR)
    })
    StudentCourse selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StudentCourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StudentCourse record);

    @Update({
        "update student_course",
        "set sno = #{sno,jdbcType=INTEGER},",
          "grade = #{grade,jdbcType=TINYINT},",
          "curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StudentCourse record);
}