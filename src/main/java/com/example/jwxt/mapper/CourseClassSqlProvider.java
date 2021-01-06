package com.example.jwxt.mapper;

import com.example.jwxt.entity.CourseClass;
import org.apache.ibatis.jdbc.SQL;

public class CourseClassSqlProvider {
    public String insertSelective(CourseClass record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("course_class");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCno() != null) {
            sql.VALUES("cno", "#{cno,jdbcType=INTEGER}");
        }
        
        if (record.getCurriculaVariable() != null) {
            sql.VALUES("curricula_variable", "#{curriculaVariable,jdbcType=VARCHAR}");
        }
        
        if (record.getTimePeriod() != null) {
            sql.VALUES("time_period", "#{timePeriod,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}