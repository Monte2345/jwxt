package com.example.jwxt.entity;

public class TeachingClass {
    private Integer id;

    private Integer cno;

    private String curriculaVariable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public String getCurriculaVariable() {
        return curriculaVariable;
    }

    public void setCurriculaVariable(String curriculaVariable) {
        this.curriculaVariable = curriculaVariable == null ? null : curriculaVariable.trim();
    }
}