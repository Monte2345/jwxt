package com.example.jwxt.mapper;

import com.example.jwxt.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CourseMapper {
    @Delete({
        "delete from course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into course (id, cno, ",
        "name, credit, type, ",
        "status, class_hours)",
        "values (#{id,jdbcType=INTEGER}, #{cno,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{credit,jdbcType=TINYINT}, #{type,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{classHours,jdbcType=TINYINT})"
    })
    int insert(Course record);

    @InsertProvider(type=CourseSqlProvider.class, method="insertSelective")
    int insertSelective(Course record);

    @Select({
        "select",
        "id, cno, name, credit, type, status, class_hours",
        "from course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cno", property="cno", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="credit", property="credit", jdbcType=JdbcType.TINYINT),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_hours", property="classHours", jdbcType=JdbcType.TINYINT)
    })
    Course selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Course record);

    @Update({
        "update course",
        "set cno = #{cno,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "credit = #{credit,jdbcType=TINYINT},",
          "type = #{type,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "class_hours = #{classHours,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Course record);
}