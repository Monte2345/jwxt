package com.example.jwxt.mapper;

import com.example.jwxt.entity.TeacherGroup;
import org.apache.ibatis.jdbc.SQL;

public class TeacherGroupSqlProvider {
    public String insertSelective(TeacherGroup record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("teacher_group");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getGno() != null) {
            sql.VALUES("gno", "#{gno,jdbcType=INTEGER}");
        }
        
        if (record.getTno() != null) {
            sql.VALUES("tno", "#{tno,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TeacherGroup record) {
        SQL sql = new SQL();
        sql.UPDATE("teacher_group");
        
        if (record.getGno() != null) {
            sql.SET("gno = #{gno,jdbcType=INTEGER}");
        }
        
        if (record.getTno() != null) {
            sql.SET("tno = #{tno,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}