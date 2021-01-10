package com.example.jwxt.mapper;

import com.example.jwxt.entity.ClassSchedule;
import org.apache.ibatis.jdbc.SQL;

public class ClassScheduleSqlProvider {
    public String insertSelective(ClassSchedule record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("class_schedule");
        
        if (record.getGno() != null) {
            sql.VALUES("gno", "#{gno,jdbcType=INTEGER}");
        }
        
        if (record.getTno() != null) {
            sql.VALUES("tno", "#{tno,jdbcType=INTEGER}");
        }
        
        if (record.getCno() != null) {
            sql.VALUES("cno", "#{cno,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getCredit() != null) {
            sql.VALUES("credit", "#{credit,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }
}