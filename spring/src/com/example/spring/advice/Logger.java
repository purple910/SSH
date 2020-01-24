package com.example.spring.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: spring-01 com.example.spring.advice.Logger
 * @description: 注解
 * @author: fate
 * @create: 2019-09-21 10:26
 **/
@Aspect
@Component
public class Logger {

    @Pointcut("execution(* com.example.spring.*.service.impl.*ServiceImpl.*(..))")
    public void pointcut(){}

//    @Before(value = "execution(* com.example.spring.aop.service.impl.AopServiceImpl.create(String,int ))")
    @Before("pointcut()")
    public void  logger(){
        System.out.println("Logger.logger");
    }
}
