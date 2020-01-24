package com.example.onetomany;

/**
 * @program: hibernate-01 com.example.onetomany
 * @description: 一对多
 * @author: fate
 * @create: 2019-09-18 19:14
 **/
public class EmpEntity {
    private String eid;
    private String ename;
    private DeptEntity dept;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public DeptEntity getDept() {
        return dept;
    }

    public void setDept(DeptEntity dept) {
        this.dept = dept;
    }
}
