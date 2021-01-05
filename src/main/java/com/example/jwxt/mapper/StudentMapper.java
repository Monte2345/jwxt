package com.example.jwxt.mapper;

import com.example.jwxt.entity.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface StudentMapper {
    @Delete({
        "delete from student",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into student (id, sno, ",
        "name, student_class, ",
        "gpa, pwd)",
        "values (#{id,jdbcType=INTEGER}, #{sno,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{studentClass,jdbcType=VARCHAR}, ",
        "#{gpa,jdbcType=REAL}, #{pwd,jdbcType=VARCHAR})"
    })
    int insert(Student record);

    @InsertProvider(type=StudentSqlProvider.class, method="insertSelective")
    int insertSelective(Student record);

    @Select({
        "select",
        "id, sno, name, student_class, gpa, pwd",
        "from student",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sno", property="sno", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_class", property="studentClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="gpa", property="gpa", jdbcType=JdbcType.REAL),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR)
    })
    Student selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Student record);

    @Update({
        "update student",
        "set sno = #{sno,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "student_class = #{studentClass,jdbcType=VARCHAR},",
          "gpa = #{gpa,jdbcType=REAL},",
          "pwd = #{pwd,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Student record);

    @Select({
            "select",
            "pwd",
            "from student",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR)
    })
    String selectPwdByPrimaryKey(Integer id);

    @Select({
            "select",
            "id",
            "from student",
            "where sno = #{sno,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER)
    })
    Integer selectPrimaryKeyBySno(Integer sno);
}