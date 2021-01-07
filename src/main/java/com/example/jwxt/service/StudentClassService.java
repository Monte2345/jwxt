package com.example.jwxt.service;

import com.example.jwxt.support.returnEntity.ServerReturnObject;

public interface StudentClassService {
    ServerReturnObject insert(Integer sno,String curriculaVariable);

    boolean judgeCurricula(Integer sno, String curriculaVariable);

    boolean judgeCno(Integer sno, Integer cno);

    ServerReturnObject getSchedule(Integer sno);

    ServerReturnObject delete(Integer sno, String curriculaVariable);
}
