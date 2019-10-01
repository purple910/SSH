package com.company.entity;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Past;
import java.util.Date;


/**
 * @program: springMVC-02 com.company.handler.Student
 * @description: student
 * @author: fate
 * @create: 2019-09-30 12:22
 **/
public class Student {

    private int id;
    private String name;
    private int age;
    private Address address;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date brithday;

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", date=" + brithday +
                '}';
    }
}
