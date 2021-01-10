package com.example.jwxt.entity;

import java.util.ArrayList;
import java.util.List;

public class StudentClasses {
    public StudentClasses(){
        this.studentClassList = new ArrayList<StudentClass>();
    }

    private List<StudentClass> studentClassList;

    public List<StudentClass> getStudentClassList() {
        return studentClassList;
    }

    public void setStudentClassList(List<StudentClass> studentClassList) {
        this.studentClassList = studentClassList;
    }
}
