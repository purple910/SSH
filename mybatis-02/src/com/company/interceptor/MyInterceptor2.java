package com.company.interceptor;


import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;

/**
 * @program: mybatis-02 com.company.interceptor.MyInterceptor
 * @description: 拦截器
 * @author: fate
 * @create: 2019-10-10 14:49
 **/

@Intercepts({
        @Signature(type = StatementHandler.class , method = "query" , args = {Statement.class , ResultHandler.class})
})
public class MyInterceptor2 implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object proceed = invocation.proceed();
        System.out.println("proceed22 = " + proceed);
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        Object wrap = Plugin.wrap(target, this);
        System.out.println("wrap222 = " + wrap);
        return wrap;
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("properties22 = " + properties);
    }
}
