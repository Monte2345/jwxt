package com.example.jwxt.mapper;

import com.example.jwxt.entity.CN;
import org.apache.ibatis.jdbc.SQL;

public class CNSqlProvider {
    public String insertSelective(CN record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("c_n");
        
        if (record.getCno() != null) {
            sql.VALUES("cno", "#{cno,jdbcType=INTEGER}");
        }
        
        if (record.getNum() != null) {
            sql.VALUES("num", "#{num,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }
}