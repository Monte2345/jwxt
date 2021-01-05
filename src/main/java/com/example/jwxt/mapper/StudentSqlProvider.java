package com.example.jwxt.mapper;

import com.example.jwxt.entity.Student;
import org.apache.ibatis.jdbc.SQL;

public class StudentSqlProvider {
    public String insertSelective(Student record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("student");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getSno() != null) {
            sql.VALUES("sno", "#{sno,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getStudentClass() != null) {
            sql.VALUES("student_class", "#{studentClass,jdbcType=VARCHAR}");
        }
        
        if (record.getGpa() != null) {
            sql.VALUES("gpa", "#{gpa,jdbcType=REAL}");
        }
        
        if (record.getPwd() != null) {
            sql.VALUES("pwd", "#{pwd,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Student record) {
        SQL sql = new SQL();
        sql.UPDATE("student");
        
        if (record.getSno() != null) {
            sql.SET("sno = #{sno,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getStudentClass() != null) {
            sql.SET("student_class = #{studentClass,jdbcType=VARCHAR}");
        }
        
        if (record.getGpa() != null) {
            sql.SET("gpa = #{gpa,jdbcType=REAL}");
        }
        
        if (record.getPwd() != null) {
            sql.SET("pwd = #{pwd,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}