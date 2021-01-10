package com.example.jwxt.mapper;

import com.example.jwxt.entity.TeacherGroup;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface TeacherGroupMapper {
    @Delete({
        "delete from teacher_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into teacher_group (id, gno, ",
        "tno)",
        "values (#{id,jdbcType=INTEGER}, #{gno,jdbcType=INTEGER}, ",
        "#{tno,jdbcType=INTEGER})"
    })
    int insert(TeacherGroup record);

    @InsertProvider(type=TeacherGroupSqlProvider.class, method="insertSelective")
    int insertSelective(TeacherGroup record);

    @Select({
        "select",
        "id, gno, tno",
        "from teacher_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="gno", property="gno", jdbcType=JdbcType.INTEGER),
        @Result(column="tno", property="tno", jdbcType=JdbcType.INTEGER)
    })
    TeacherGroup selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TeacherGroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TeacherGroup record);

    @Update({
        "update teacher_group",
        "set gno = #{gno,jdbcType=INTEGER},",
          "tno = #{tno,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TeacherGroup record);
}