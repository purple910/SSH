package com.company.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @program: springMVC-02 com.company.entity.People
 * @description: springmvc标签
 * @author: fate
 * @create: 2019-10-02 10:14
 **/
public class People  implements Serializable {
    private String name;
    private int age;
    private boolean sex;

    private List<String> hobbis;
    private List<String> course;
    private List<Dept> depts;

    private String city;
    private String home;

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Dept> getDepts() {
        return depts;
    }

    public void setDepts(List<Dept> depts) {
        this.depts = depts;
    }

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }

    public boolean isSex() {
        return sex;
    }

    public List<String> getHobbis() {
        return hobbis;
    }

    public void setHobbis(List<String> hobbis) {
        this.hobbis = hobbis;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
