package com.company.entity;

import java.io.Serializable;

/**
 * @program: mybatis-01 com.company.entity.AddressEntity
 * @description: addresss
 * @author: fate
 * @create: 2019-09-23 20:43
 **/
public class AddressEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String homeaddress;
    private String schooleaddress;

    public AddressEntity() {
    }

    public AddressEntity(String homeaddress, String schooleaddress) {
        this.homeaddress = homeaddress;
        this.schooleaddress = schooleaddress;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "homeaddress='" + homeaddress + '\'' +
                ", schooleaddress='" + schooleaddress + '\'' +
                '}';
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    public String getSchooleaddress() {
        return schooleaddress;
    }

    public void setSchooleaddress(String schooleaddress) {
        this.schooleaddress = schooleaddress;
    }
}
