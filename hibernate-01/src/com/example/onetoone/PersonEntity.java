package com.example.onetoone;

/**
 * @program: hibernate-01 com.example.entity.onetoone
 * @description: person
 * @author: fate
 * @create: 2019-09-18 17:01
 **/
public class PersonEntity {
    private String pid;
    private String pname;
    private CardEntity card;

    public PersonEntity() {
    }

    public PersonEntity(String pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public CardEntity getCard() {
        return card;
    }

    public void setCard(CardEntity card) {
        this.card = card;
    }
}
