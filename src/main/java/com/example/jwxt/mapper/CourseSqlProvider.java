package com.example.jwxt.mapper;

import com.example.jwxt.entity.Course;
import org.apache.ibatis.jdbc.SQL;

public class CourseSqlProvider {
    public String insertSelective(Course record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("course");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCno() != null) {
            sql.VALUES("cno", "#{cno,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCredit() != null) {
            sql.VALUES("credit", "#{credit,jdbcType=TINYINT}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getClassHours() != null) {
            sql.VALUES("class_hours", "#{classHours,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Course record) {
        SQL sql = new SQL();
        sql.UPDATE("course");
        
        if (record.getCno() != null) {
            sql.SET("cno = #{cno,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCredit() != null) {
            sql.SET("credit = #{credit,jdbcType=TINYINT}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getClassHours() != null) {
            sql.SET("class_hours = #{classHours,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}