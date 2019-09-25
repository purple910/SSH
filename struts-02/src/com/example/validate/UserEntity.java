package com.example.validate;

import java.util.Date;

/**
 * @program: struts-02 com.example.validate
 * @description: user
 * @author: fate
 * @create: 2019-09-20 12:08
 **/
public class UserEntity {
    private String name;
    private String password;
    private Date date;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
