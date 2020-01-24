package com.example.entity;

import com.baomidou.mybatisplus.annotation.*;

/**
 * @program: mybatis-plus-01 com.example.entity.Student
 * @description:
 * @author: fate
 * @create: 2019-10-10 19:37
 **/
//@TableName(value = "mybatis_plus_student")
@TableName(value = "student",keepGlobalPrefix = true)
public class Student {
    /**
     * 主键,自增
     */
    @TableId(value = "stu_no",type = IdType.AUTO)
    private int stuNo;
    @TableField(value = "stu_name" , fill = FieldFill.INSERT_UPDATE)
    private String stuName;
//    @TableField(value = "stuage")
    private int stuAge;

    @TableField(exist = false)
    private String sex;

    @Version
    private Integer version;

    @TableLogic
    private int logicDelete;

    public Student() {
    }

    public Student(String stuName, int stuAge) {
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    public Student(int stuNo, String stuName, int stuAge) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    public int getLogicDelete() {
        return logicDelete;
    }

    public void setLogicDelete(int logicDelete) {
        this.logicDelete = logicDelete;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
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
