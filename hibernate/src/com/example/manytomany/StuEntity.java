package com.example.manytomany;

import java.util.Set;

/**
 * @program: hibernate-01 com.example.manytomany
 * @description: 多对多
 * @author: fate
 * @create: 2019-09-18 20:18
 **/
public class StuEntity {
    private String sid;
    private String sname;

    private Set<CourseEntity> course;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Set<CourseEntity> getCourse() {
        return course;
    }

    public void setCourse(Set<CourseEntity> course) {
        this.course = course;
    }
}
