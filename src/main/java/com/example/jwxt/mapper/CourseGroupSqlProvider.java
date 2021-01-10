package com.example.jwxt.mapper;

import com.example.jwxt.entity.CourseGroup;
import org.apache.ibatis.jdbc.SQL;

public class CourseGroupSqlProvider {
    public String insertSelective(CourseGroup record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("course_group");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getGno() != null) {
            sql.VALUES("gno", "#{gno,jdbcType=INTEGER}");
        }
        
        if (record.getCno() != null) {
            sql.VALUES("cno", "#{cno,jdbcType=INTEGER}");
        }
        
        if (record.getTno() != null) {
            sql.VALUES("tno", "#{tno,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CourseGroup record) {
        SQL sql = new SQL();
        sql.UPDATE("course_group");
        
        if (record.getGno() != null) {
            sql.SET("gno = #{gno,jdbcType=INTEGER}");
        }
        
        if (record.getCno() != null) {
            sql.SET("cno = #{cno,jdbcType=INTEGER}");
        }
        
        if (record.getTno() != null) {
            sql.SET("tno = #{tno,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}