package com.example.jwxt.mapper;

import com.example.jwxt.entity.TeacherCourse;
import org.apache.ibatis.jdbc.SQL;

public class TeacherCourseSqlProvider {
    public String insertSelective(TeacherCourse record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("teacher_course");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTno() != null) {
            sql.VALUES("tno", "#{tno,jdbcType=INTEGER}");
        }
        
        if (record.getTimePeriod() != null) {
            sql.VALUES("time_period", "#{timePeriod,jdbcType=VARCHAR}");
        }
        
        if (record.getCurriculaVariable() != null) {
            sql.VALUES("curricula_variable", "#{curriculaVariable,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TeacherCourse record) {
        SQL sql = new SQL();
        sql.UPDATE("teacher_course");
        
        if (record.getTno() != null) {
            sql.SET("tno = #{tno,jdbcType=INTEGER}");
        }
        
        if (record.getTimePeriod() != null) {
            sql.SET("time_period = #{timePeriod,jdbcType=VARCHAR}");
        }
        
        if (record.getCurriculaVariable() != null) {
            sql.SET("curricula_variable = #{curriculaVariable,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}