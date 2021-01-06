package com.example.jwxt.entity;

public class StudentClass {
    private Integer id;

    private Integer sno;

    private Byte grade;

    private String curriculaVariable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public Byte getGrade() {
        return grade;
    }

    public void setGrade(Byte grade) {
        this.grade = grade;
    }

    public String getCurriculaVariable() {
        return curriculaVariable;
    }

    public void setCurriculaVariable(String curriculaVariable) {
        this.curriculaVariable = curriculaVariable == null ? null : curriculaVariable.trim();
    }
}