package com.example.jwxt.entity;

public class CC {
    private String coursename;

    private Integer coursecno;

    private String type;

    private Byte credit;

    private String curriculavariable;

    private String timeperiod;

    private Integer teachername;

    private String tno;

    private Integer capacity;

    private Integer enrollment;

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public Integer getCoursecno() {
        return coursecno;
    }

    public void setCoursecno(Integer coursecno) {
        this.coursecno = coursecno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Byte getCredit() {
        return credit;
    }

    public void setCredit(Byte credit) {
        this.credit = credit;
    }

    public String getCurriculavariable() {
        return curriculavariable;
    }

    public void setCurriculavariable(String curriculavariable) {
        this.curriculavariable = curriculavariable == null ? null : curriculavariable.trim();
    }

    public String getTimeperiod() {
        return timeperiod;
    }

    public void setTimeperiod(String timeperiod) {
        this.timeperiod = timeperiod == null ? null : timeperiod.trim();
    }

    public Integer getTeachername() {
        return teachername;
    }

    public void setTeachername(Integer teachername) {
        this.teachername = teachername;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno == null ? null : tno.trim();
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