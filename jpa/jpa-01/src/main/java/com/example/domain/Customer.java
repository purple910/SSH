package com.example.domain;

import javax.persistence.*;

/**
 * @program: jpa-01 com.Customer
 * @description:
 * @author: fate
 * @create: 2019-10-13 22:26
 **/
@Entity
@Table(name = "jpa_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //主键生成策略
    @Column(name = "id")
    private Long id;

//    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "source")
    private String source;

    @Column(name = "level")
    private String level;

    @Column(name = "phone")
    private String phone;

    @Column(name = "industry")
    private String industry;

    public Customer() {
    }


    public Customer(String name, String address, String source, String level, String phone, String industry) {
        this.name = name;
        this.address = address;
        this.source = source;
        this.level = level;
        this.phone = phone;
        this.industry = industry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", source='" + source + '\'' +
                ", level='" + level + '\'' +
                ", phone='" + phone + '\'' +
                ", industry='" + industry + '\'' +
                '}';
    }
}
