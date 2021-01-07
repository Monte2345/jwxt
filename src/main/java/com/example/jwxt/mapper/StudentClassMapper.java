package com.example.jwxt.mapper;

import com.example.jwxt.entity.StudentClass;
import com.example.jwxt.support.returnEntity.ServerReturnObject;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;
@Mapper
public interface StudentClassMapper {
    @Delete({
        "delete from student_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into student_class (id, sno, ",
        "grade, curricula_variable)",
        "values (#{id,jdbcType=INTEGER}, #{sno,jdbcType=INTEGER}, ",
        "#{grade,jdbcType=TINYINT}, #{curriculaVariable,jdbcType=VARCHAR})"
    })
    int insert(StudentClass record);

    @InsertProvider(type=StudentClassSqlProvider.class, method="insertSelective")
    int insertSelective(StudentClass record);

    @Select({
        "select",
        "id, sno, grade, curricula_variable",
        "from student_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sno", property="sno", jdbcType=JdbcType.INTEGER),
        @Result(column="grade", property="grade", jdbcType=JdbcType.TINYINT),
        @Result(column="curricula_variable", property="curriculaVariable", jdbcType=JdbcType.VARCHAR)
    })
    StudentClass selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StudentClassSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StudentClass record);

    @Update({
        "update student_class",
        "set sno = #{sno,jdbcType=INTEGER},",
          "grade = #{grade,jdbcType=TINYINT},",
          "curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StudentClass record);

    @Select({
            "select",
            "id, sno, grade, curricula_variable",
            "from student_class",
            "where sno = #{sno,jdbcType=INTEGER} and " +
                    "curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}"
    })
    List<StudentClass> findBySnoAndCurricula(Integer sno, String curriculaVariable);
    @Select({
            "select *",
            "from student_schedule",
            "where sno = #{sno,jdbcType=INTEGER} and " +
                    "cno = #{cno,jdbcType=INTEGER}"
    })
    List<Map<String, Object>> judgeCno(Integer sno, Integer cno);

    @Select({
            "select *",
            "from student_schedule",
            "where sno = #{sno,jdbcType=INTEGER}  "
    })
    List<Map<String, Object>> getSchedule(Integer sno);

    @Select({
            "select",
            "id",
            "from student_class",
            "where sno = #{sno,jdbcType=INTEGER} and",
            "curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
    })
    Integer selectIdBySnoAndCurriculaVariable(Integer sno,String curriculaVariable);

    @Select({
            "select count(*)",
            "from student_class",
            "where ",
            "curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}"
    })
    Integer getEnrollment(String curriculaVariable);
}