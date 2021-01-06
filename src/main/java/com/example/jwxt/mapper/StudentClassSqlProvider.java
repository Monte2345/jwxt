package com.example.jwxt.mapper;

import com.example.jwxt.entity.StudentClass;
import org.apache.ibatis.jdbc.SQL;

public class StudentClassSqlProvider {
    public String insertSelective(StudentClass record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("student_class");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getSno() != null) {
            sql.VALUES("sno", "#{sno,jdbcType=INTEGER}");
        }
        
        if (record.getGrade() != null) {
            sql.VALUES("grade", "#{grade,jdbcType=TINYINT}");
        }
        
        if (record.getCurriculaVariable() != null) {
            sql.VALUES("curricula_variable", "#{curriculaVariable,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(StudentClass record) {
        SQL sql = new SQL();
        sql.UPDATE("student_class");
        
        if (record.getSno() != null) {
            sql.SET("sno = #{sno,jdbcType=INTEGER}");
        }
        
        if (record.getGrade() != null) {
            sql.SET("grade = #{grade,jdbcType=TINYINT}");
        }
        
        if (record.getCurriculaVariable() != null) {
            sql.SET("curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}