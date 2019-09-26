package com.company.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @program: mybatis-01 com.company.entity.PeopleClassEntity
 * @description: class
 * @author: fate
 * @create: 2019-09-25 17:29
 **/
public class PeopleClassEntity implements Serializable {
    private int classid;
    private String classname;

    //onr to many
    protected List<PeopleEntity> peopleEntity;

    public List<PeopleEntity> getPeopleEntity() {
        return peopleEntity;
    }

    public void setPeopleEntity(List<PeopleEntity> peopleEntity) {
        this.peopleEntity = peopleEntity;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "PeopleClassEntity{" +
                "classid=" + classid +
                ", classname='" + classname + "\n" +
                ", peopleEntity=" + peopleEntity +
                '}'+"\n";
    }
}
