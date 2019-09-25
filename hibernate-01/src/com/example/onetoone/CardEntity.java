package com.example.onetoone;

/**
 * @program: hibernate-01 com.example.onetoone
 * @description: card
 * @author: fate
 * @create: 2019-09-18 17:01
 **/
public class CardEntity {
    private String cid;
    private String cnum;
    private PersonEntity person;

    public CardEntity() {
    }

    public CardEntity(String cid, String cnum) {
        this.cid = cid;
        this.cnum = cnum;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }
}
