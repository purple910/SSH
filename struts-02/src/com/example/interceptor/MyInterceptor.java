package com.example.interceptor;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        //进入拦截器
        System.out.println("11111111111");
        //放行
        String invoke = actionInvocation.invoke();
        // 出去拦截器
        System.out.println("2222222222");
        // return "";直接跳转，不进去action
        return invoke;
    }
}
