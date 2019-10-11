package com.company.entity;

/**
 * @program: mybatis-02 com.company.entity.Student
 * @description:
 * @author: fate
 * @create: 2019-10-08 13:16
 **/
public class Student {
    private Integer id;
    private String name;
    private int age;
    private String gname;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String gname) {
        this.name = name;
        this.age = age;
        this.gname = gname;
    }

    public Student(Integer id, String name, int age, String gname) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gname = gname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gname='" + gname + '\'' +
                '}';
    }


    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
