package com.example.manytomany;

import java.util.Set;

/**
 * @program: hibernate-01 com.example.manytomany
 * @description: 多对多
 * @author: fate
 * @create: 2019-09-18 20:18
 **/
public class CourseEntity {

    private String cid;
    private String cname;

    private Set<StuEntity> stu;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<StuEntity> getStu() {
        return stu;
    }

    public void setStu(Set<StuEntity> stu) {
        this.stu = stu;
    }
}
