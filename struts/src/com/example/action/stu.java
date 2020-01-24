package com.example.action;

import com.example.factory.UserBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class stu extends ActionSupport {


    private UserBean user ;

    public UserBean getUser() {
        return user;
    }


    private List list = new ArrayList();

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String see() throws Exception{
        for(int i=0;i<9;i++){
            UserBean user = new UserBean();
            user.setName("Name"+i);
            user.setPassword("Password"+i);
            list.add(user);
        }
        return LOGIN;
    }

}
