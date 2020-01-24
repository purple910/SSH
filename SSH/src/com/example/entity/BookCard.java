package com.example.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: SSH-02 com.example.entity.BookCard
 * @description:
 * @author: fate
 * @create: 2019-10-04 16:53
 **/
public class BookCard {
    private int cid  ;
    private String name;
    private String sex ;
    private Date cardDate;

    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Date getCardDate() {
        return cardDate;
    }
    public void setCardDate(Date cardDate) {
        this.cardDate = cardDate;
    }

    @Override
    public String toString() {
        return "BookCard{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", cardDate=" + cardDate +
                '}';
    }
}
