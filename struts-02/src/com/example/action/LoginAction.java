package com.example.action;

import com.example.factory.UserBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private UserBean user;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String show() throws Exception{


        System.out.println("name:"+user.getName());
        ActionContext context = ActionContext.getContext();
        context.put("name",user.getName());
        return LOGIN;
    }

    @Override
    public String execute() throws Exception{
        System.out.println("name:"+user.getName());
        return SUCCESS;
    }
}
