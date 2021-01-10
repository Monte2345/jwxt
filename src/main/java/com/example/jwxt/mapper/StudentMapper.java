package com.example.jwxt.mapper;

import com.example.jwxt.entity.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

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

    @Select({
            "select *",
            "from grade",
            "where sno = #{sno,jdbcType=INTEGER}"
    })
    List<Map<String, Object>> getGrade(Integer sno);

    @Select({
            "select avg_gpa",
            "from gpa",
            "where sno = #{sno,jdbcType=INTEGER}"
    })
    Float getGPA(Integer sno);

    @Select({
            "select pm from \n" +
                    "(SELECT\n" +
                    "\t\t\tt1.*,@rank :=@rank + 1 AS pm\n" +
                    "\t\tFROM\n" +
                    "\t\t\t(\n" +
                    "\t\t\t\tSELECT\n" +
                    "\t\t\t\t\t*\n" +
                    "\t\t\t\tFROM\n" +
                    "\t\t\t\t\tgpa\n" +
                    "\t\t\t\tORDER BY\n" +
                    "\t\t\t\t\tgpa.avg_gpa DESC\n" +
                    "\t\t\t) AS t1,\n" +
                    "\t\t\t(SELECT @rank := 0) AS t2\n" +
                    " \n" +
                    ") as m\n" +
                    "WHERE sno=#{sno,jdbcType=INTEGER}"
    })
    Integer getRank(Integer sno);
}