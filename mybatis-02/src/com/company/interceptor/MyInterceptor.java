package com.company.interceptor;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;

/**
 * type:
 *  StatementHandler,ParameterHandler,ResultSetHandler,Executor
 * @program: mybatis-02 com.company.interceptor.MyInterceptor
 * @description: 拦截器
 * @author: fate
 * @create: 2019-10-10 14:49
 **/
//
//@Intercepts({
//        @Signature(type = StatementHandler.class, method = "query" , args = {Statement.class , ResultHandler.class})
//})
@Intercepts({
        @Signature(type = StatementHandler.class, method = "parameterize" , args = {Statement.class })
})
public class MyInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        Object target = invocation.getTarget(); //目标方法:sql
        System.out.println("target = " + target);

        MetaObject metaObject = SystemMetaObject.forObject(target);//target包装后的产物

//        Object value = metaObject.getValue("parameterHandler.parameterObject"); //参数
//        System.out.println("value = " + value);
//        metaObject.setValue("parameterHandler.parameterObject",1);
//        Object value2 = metaObject.getValue("parameterHandler.parameterObject");
//        System.out.println("value2 = " + value2);

        Object value = metaObject.getValue("parameterHandler.boundSql.sql");    //parameterObject
        System.out.println("value = " + value);

        Object proceed = invocation.proceed();

        System.out.println("proceed = " + proceed);
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        Object wrap = Plugin.wrap(target, this);
//        System.out.println("wrap = " + wrap);
        return wrap;
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("properties = " + properties);
    }
}
