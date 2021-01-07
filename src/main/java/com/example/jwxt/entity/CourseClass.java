package com.example.jwxt.entity;

public class CourseClass {
    private Integer id;

    private Integer cno;

    private String curriculaVariable;

    private String timePeriod;

    private Integer capacity;

    private Integer enrollment;

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

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod == null ? null : timePeriod.trim();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Integer enrollment) {
        this.enrollment = enrollment;
    }
}