package com.example.onetomany;

import java.util.Set;

/**
 * @program: hibernate-01 com.example.onetomany
 * @description: 一对多
 * @author: fate
 * @create: 2019-09-18 19:15
 **/
public class DeptEntity {
    private String did;
    private String dname;

    private Set<EmpEntity> emp;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Set<EmpEntity> getEmp() {
        return emp;
    }

    public void setEmp(Set<EmpEntity> emp) {
        this.emp = emp;
    }


}
