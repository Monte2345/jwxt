package com.example.jwxt.mapper;

import com.example.jwxt.entity.CourseGroup;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface CourseGroupMapper {
    @Delete({
        "delete from course_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into course_group (id, gno, ",
        "cno, tno)",
        "values (#{id,jdbcType=INTEGER}, #{gno,jdbcType=INTEGER}, ",
        "#{cno,jdbcType=INTEGER}, #{tno,jdbcType=INTEGER})"
    })
    int insert(CourseGroup record);

    @InsertProvider(type=CourseGroupSqlProvider.class, method="insertSelective")
    int insertSelective(CourseGroup record);

    @Select({
        "select",
        "id, gno, cno, tno",
        "from course_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="gno", property="gno", jdbcType=JdbcType.INTEGER),
        @Result(column="cno", property="cno", jdbcType=JdbcType.INTEGER),
        @Result(column="tno", property="tno", jdbcType=JdbcType.INTEGER)
    })
    CourseGroup selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CourseGroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CourseGroup record);

    @Update({
        "update course_group",
        "set gno = #{gno,jdbcType=INTEGER},",
          "cno = #{cno,jdbcType=INTEGER},",
          "tno = #{tno,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CourseGroup record);
}