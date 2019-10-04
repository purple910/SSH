package com.example.demo.factory;

import java.sql.Date;

public class MotifyBean {
    String id;
    String name;
    String grade;
    String mojor;
    Date start;
    Date end;
    int publish;
    int total;
    int number;
    double excellent;
    String teacherId;

    public MotifyBean() {

    }

    public MotifyBean(String id, String name, String grade, String mojor, Date start, Date end, int publish, int total, int number, double excellent, String teacherId) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.mojor = mojor;
        this.start = start;
        this.end = end;
        this.publish = publish;
        this.total = total;
        this.number = number;
        this.excellent = excellent;
        this.teacherId = teacherId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getExcellent() {
        return excellent;
    }

    public void setExcellent(double excellent) {
        this.excellent = excellent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMojor() {
        return mojor;
    }

    public void setMojor(String mojor) {
        this.mojor = mojor;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getPublish() {
        return publish;
    }

    public void setPublish(int publish) {
        this.publish = publish;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
