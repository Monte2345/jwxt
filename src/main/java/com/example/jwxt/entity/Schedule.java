package com.example.jwxt.entity;

import java.util.ArrayList;
import java.util.List;

public class Schedule {


    public Schedule() {
        this.curriculaVariables = new ArrayList<String>();
        this.tnoList = new ArrayList<Integer>();
        this.cnoList = new ArrayList<Integer>();
    }

    private List<String> curriculaVariables;

    private List<Integer>tnoList;

    private List<Integer>cnoList;

    public List<String> getCurriculaVariables(){
        return curriculaVariables;
    }

    public List<Integer> getTnoList(){
        return tnoList;
    }

    public List<Integer> getCnoList(){
        return cnoList;
    }

    public void setCurriculaVariables(List<String> curriculaVariables) {
        this.curriculaVariables = curriculaVariables;
    }

    public void setTnoList(List<Integer> tnoList) {
        this.tnoList = tnoList;
    }

    public void setCnoList(List<Integer> cnoList) {
        this.cnoList = cnoList;
    }

}
