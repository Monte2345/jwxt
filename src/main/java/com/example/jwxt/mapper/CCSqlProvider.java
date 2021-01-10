package com.example.jwxt.mapper;

import com.example.jwxt.entity.CC;
import org.apache.ibatis.jdbc.SQL;

public class CCSqlProvider {
    public String insertSelective(CC record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("c_c");
        
        if (record.getCoursename() != null) {
            sql.VALUES("courseName", "#{coursename,jdbcType=VARCHAR}");
        }
        
        if (record.getCoursecno() != null) {
            sql.VALUES("courseCno", "#{coursecno,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getCredit() != null) {
            sql.VALUES("credit", "#{credit,jdbcType=TINYINT}");
        }
        
        if (record.getCurriculavariable() != null) {
            sql.VALUES("curriculaVariable", "#{curriculavariable,jdbcType=VARCHAR}");
        }
        
        if (record.getTimeperiod() != null) {
            sql.VALUES("timePeriod", "#{timeperiod,jdbcType=VARCHAR}");
        }
        
        if (record.getTeachername() != null) {
            sql.VALUES("teacherName", "#{teachername,jdbcType=INTEGER}");
        }
        
        if (record.getTno() != null) {
            sql.VALUES("tno", "#{tno,jdbcType=VARCHAR}");
        }
        
        if (record.getCapacity() != null) {
            sql.VALUES("capacity", "#{capacity,jdbcType=INTEGER}");
        }
        
        if (record.getEnrollment() != null) {
            sql.VALUES("enrollment", "#{enrollment,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }
}