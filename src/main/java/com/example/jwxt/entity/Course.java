package com.example.jwxt.entity;

public class Course {
    private Integer id;

    private Integer cno;

    private String name;

    private Byte credit;

    private String type;

    private String status;

    private Byte classHours;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getCredit() {
        return credit;
    }

    public void setCredit(Byte credit) {
        this.credit = credit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Byte getClassHours() {
        return classHours;
    }

    public void setClassHours(Byte classHours) {
        this.classHours = classHours;
    }
}