package com.example.interceptor;

import com.example.action.LoginAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class Interce extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        // 登录拦截

        //是否是登录操作
        if(LoginAction.class.equals(actionInvocation.getAction().getClass())) {
            //不让他回来后还操作
            return actionInvocation.invoke();
        }
        // 是否已经登录
        else {
            Map<String, Object> session = ActionContext.getContext().getSession();
            String name = (String)session.get("name");

//            HttpSession httpSession = ServletActionContext.getRequest().getSession();
//            String login = (String)httpSession.getAttribute("name");
//
            if(null!=name && "".equals(name)) {
                return actionInvocation.invoke();
            }
        }

        return "login";
    }
}
