package com.company.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @program: mybatis-01 com.company.entity.PeopleEntity
 * @description: people
 * @author: fate
 * @create: 2019-09-21 17:18
 **/
public class PeopleEntity implements Serializable {

    private static final long serialVersionUID = 1L;



    private int id;
    private String name;
    private int age;
    private boolean sex;
    private AddressEntity address;

    //one to one
    private PeopleCardEntity cardEntity;




    public PeopleEntity() {
    }

    public PeopleEntity(int id) {
        this.id = id;
    }

    public PeopleEntity(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public PeopleEntity(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public PeopleEntity(int id, String name, int age, boolean sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public PeopleCardEntity getCardEntity() {
        return cardEntity;
    }

    public void setCardEntity(PeopleCardEntity cardEntity) {
        this.cardEntity = cardEntity;
    }


    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
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

    @Override
    public String toString() {
        return "PeopleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +"\n"+
                ", address=" + address +"\n"+
                ", cardEntity=" + cardEntity +
                '}'+"\n";
    }
}
