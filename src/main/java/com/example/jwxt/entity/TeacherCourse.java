package com.example.jwxt.entity;

public class TeacherCourse {
    private Integer id;

    private Integer tno;

    private String timePeriod;

    private String curriculaVariable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTno() {
        return tno;
    }

    public void setTno(Integer tno) {
        this.tno = tno;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod == null ? null : timePeriod.trim();
    }

    public String getCurriculaVariable() {
        return curriculaVariable;
    }

    public void setCurriculaVariable(String curriculaVariable) {
        this.curriculaVariable = curriculaVariable == null ? null : curriculaVariable.trim();
    }
}