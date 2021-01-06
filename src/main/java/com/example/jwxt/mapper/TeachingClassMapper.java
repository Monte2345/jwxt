package com.example.jwxt.mapper;

import com.example.jwxt.entity.TeachingClass;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TeachingClassMapper {
    @Delete({
        "delete from teaching_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into teaching_class (id, cno, ",
        "curricula_variable)",
        "values (#{id,jdbcType=INTEGER}, #{cno,jdbcType=INTEGER}, ",
        "#{curriculaVariable,jdbcType=VARCHAR})"
    })
    int insert(TeachingClass record);

    @InsertProvider(type=TeachingClassSqlProvider.class, method="insertSelective")
    int insertSelective(TeachingClass record);

    @Select({
        "select",
        "id, cno, curricula_variable",
        "from teaching_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cno", property="cno", jdbcType=JdbcType.INTEGER),
        @Result(column="curricula_variable", property="curriculaVariable", jdbcType=JdbcType.VARCHAR)
    })
    TeachingClass selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TeachingClassSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TeachingClass record);

    @Update({
        "update teaching_class",
        "set cno = #{cno,jdbcType=INTEGER},",
          "curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TeachingClass record);
}