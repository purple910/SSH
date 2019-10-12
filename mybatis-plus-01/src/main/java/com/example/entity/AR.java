package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * @program: mybatis-plus-01 com.example.entity.AR
 * @description:
 * @author: fate
 * @create: 2019-10-10 22:11
 **/
@TableName(value = "mybatis_plus_student")
public class AR extends Model<AR> {

    @TableId(value = "stu_no",type = IdType.AUTO)
    private int stuNo;
    private String stuName;
    private int stuAge;

    public AR() {
    }

    public AR(int stuNo, String stuName, int stuAge) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    public AR(String stuName, int stuAge) {
        this.stuName = stuName;
        this.stuAge = stuAge;
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
        return "AR{" +
                "stuNo=" + stuNo +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return stuNo;
    }
}
