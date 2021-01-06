package com.example.jwxt.mapper;

import com.example.jwxt.entity.TeachingClass;
import org.apache.ibatis.jdbc.SQL;

public class TeachingClassSqlProvider {
    public String insertSelective(TeachingClass record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("teaching_class");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCno() != null) {
            sql.VALUES("cno", "#{cno,jdbcType=INTEGER}");
        }
        
        if (record.getCurriculaVariable() != null) {
            sql.VALUES("curricula_variable", "#{curriculaVariable,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TeachingClass record) {
        SQL sql = new SQL();
        sql.UPDATE("teaching_class");
        
        if (record.getCno() != null) {
            sql.SET("cno = #{cno,jdbcType=INTEGER}");
        }
        
        if (record.getCurriculaVariable() != null) {
            sql.SET("curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}