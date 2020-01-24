package com.example.spring.aop.action;

import com.example.spring.aop.service.IAopService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring-01 com.example.spring.aop.action.AopAction
 * @description: main
 * @author: fate
 * @create: 2019-09-20 17:11
 **/
public class AopAction {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-aop.xml");

        IAopService aopService = (IAopService) context.getBean("aopService");
        aopService.create("ls",18);
    }
}
