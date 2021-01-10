package com.example.jwxt.controller;

import com.example.jwxt.support.returnEntity.ServerReturnObject;

public interface StudentClassController {
    ServerReturnObject insert(Integer sno, String curriculaVariable);

    ServerReturnObject judgeCurricula(Integer sno,String curriculaVariable);

    ServerReturnObject judgeCno(Integer sno,Integer cno);

    ServerReturnObject getSchedule(Integer sno);

    ServerReturnObject delete(Integer sno, String curriculaVariable);
}
