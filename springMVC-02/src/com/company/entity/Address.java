package com.company.entity;

/**
 * @program: springMVC-02 com.company.entity.Address
 * @description: add
 * @author: fate
 * @create: 2019-09-30 12:22
 **/
public class Address {
    private String homeAddress;
    private String schoolAddress;

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "homeAddress='" + homeAddress + '\'' +
                ", schoolAddress='" + schoolAddress + '\'' +
                '}';
    }
}
