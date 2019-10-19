package com.example.domain;

import javax.persistence.*;

/**
 * @program: jpa LinkMan
 * @description:
 * @author: fate
 * @create: 2019-10-19 09:59
 **/
@Entity
@Table(name = "jpa_linkman")
public class LinkMan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lid")
    private Long lid;
    private String name;
    private String gender;
    private String phone;
    private String mobile;
    private String email;
    private String postion;
    private String meno;


    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "cust_id",referencedColumnName = "id")
    private Customer customer;



    public LinkMan() {
    }

    public LinkMan(Long lid, String name, String gender, String phone) {
        this.lid = lid;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }

    public Long getLid() {
        return lid;
    }

    public void setLid(Long id) {
        this.lid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "LinkMan{" +
                "lid=" + lid +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", postion='" + postion + '\'' +
                ", meno='" + meno + '\'' +
                '}';
    }
}
