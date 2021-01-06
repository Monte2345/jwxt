package com.example.jwxt.mapper;

import com.example.jwxt.entity.Teacher;
import org.apache.ibatis.jdbc.SQL;

public class TeacherSqlProvider {
    public String insertSelective(Teacher record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("teacher");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTno() != null) {
            sql.VALUES("tno", "#{tno,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.VALUES("pwd", "#{pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getIdentity() != null) {
            sql.VALUES("identity", "#{identity,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Teacher record) {
        SQL sql = new SQL();
        sql.UPDATE("teacher");
        
        if (record.getTno() != null) {
            sql.SET("tno = #{tno,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.SET("pwd = #{pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getIdentity() != null) {
            sql.SET("identity = #{identity,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}