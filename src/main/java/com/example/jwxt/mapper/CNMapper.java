package com.example.jwxt.mapper;

import com.example.jwxt.entity.CN;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface CNMapper {
    @Insert({
        "insert into c_n (cno, num)",
        "values (#{cno,jdbcType=INTEGER}, #{num,jdbcType=BIGINT})"
    })
    int insert(CN record);

    @InsertProvider(type=CNSqlProvider.class, method="insertSelective")
    int insertSelective(CN record);
}