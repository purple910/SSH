package com.example.spring.jdbc.action;

import com.example.spring.jdbc.service.JdbcServicen;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring-01 com.example.spring.jdbc.action.JdbcAction
 * @description: jdbc
 * @author: fate
 * @create: 2019-09-21 11:47
 **/
public class JdbcAction {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-jdbc.xml");

        JdbcServicen jdbcService = context.getBean("jdbcService",JdbcServicen.class);
        jdbcService.execute();
    }
}
