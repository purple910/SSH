package com.example.entity;


import javax.persistence.*;

/**
 * @program: mybatis-plus-01 com.example.entity.Student
 * @description:
 * @author: fate
 * @create: 2019-10-10 19:37
 **/
@Table(name = "mybatis_mapper_student")
public class Student {

    //必须是包装类 Integer Long
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //主键回写
    private Integer stuNo;
    @Column(name = "stu_name")
    private String stuName;
    @Column
    private Integer stuAge;

    @Transient
    private String other;

    public Student() {
    }

    public Student(String stuName, Integer stuAge) {
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    public Student(Integer stuNo, String stuName, Integer stuAge) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuAge = stuAge;
    }



    public Integer getStuNo() {
        return stuNo;
    }

    public void setStuNo(Integer stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo=" + stuNo +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }
}
