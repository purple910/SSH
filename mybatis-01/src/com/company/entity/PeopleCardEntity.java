package com.company.entity;

import java.io.Serializable;

/**
 * @program: mybatis-01 com.company.entity.PeopleCardEntity
 * @description: 一对一
 * @author: fate
 * @create: 2019-09-25 16:48
 **/
public class PeopleCardEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int cardId;
    private String cardInfo;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
    }

    @Override
    public String toString() {
        return "PeopleCardEntity{" +
                "cardId=" + cardId +
                ", cardInfo='" + cardInfo + '\'' +
                '}';
    }
}
