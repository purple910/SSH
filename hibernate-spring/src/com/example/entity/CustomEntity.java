package com.example.entity;

import java.util.Set;

/**
 * @program: hibernate com.example.entity.custom
 * @description: 客户信息
 * @author: fate
 * @create: 2019-10-12 09:02
 **/
public class CustomEntity {
    private int id;
    private String ninkname;
    private String passwork;
    private String name;
    private String phone;
    private String address;

    private Set<OrderEntity> orders;

    public CustomEntity() {
    }

    public CustomEntity(int id) {
        this.id = id;
    }

    public CustomEntity(String ninkname, String passwork, String name, String phone, String address) {
        this.id = id;
        this.ninkname = ninkname;
        this.passwork = passwork;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNinkname() {
        return ninkname;
    }

    public void setNinkname(String ninkname) {
        this.ninkname = ninkname;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }
    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }
    @Override
    public String toString() {
        return "custom{" +
                "ninkname='" + ninkname + '\'' +
                ", passwork='" + passwork + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }
}
