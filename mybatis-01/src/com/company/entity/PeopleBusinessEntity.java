package com.company.entity;

import java.io.Serializable;

/**
 * @program: mybatis-01 com.company.entity.PeopleBusinessEntity
 * @description: 学生扩展 (业务扩展)
 * @author: fate
 * @create: 2019-09-25 16:51
 **/
public class PeopleBusinessEntity extends PeopleEntity implements Serializable {

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
        return  "PeopleBusinessEntity{" +
                super.toString()+","+
                "cardId=" + cardId +
                ", cardInfo='" + cardInfo + '\'' +
                '}'+"\n";
    }
}
