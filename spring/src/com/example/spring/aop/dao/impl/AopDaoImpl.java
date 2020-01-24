package com.example.spring.aop.dao.impl;

import com.example.spring.aop.dao.IAopDao;

/**
 * @program: spring-01 com.example.spring.aop.dao.impl
 * @description: aopdao
 * @author: fate
 * @create: 2019-09-20 16:55
 **/
public class AopDaoImpl implements IAopDao{



    @Override
    public void create(String name, int age) {
        System.out.println("AopDaoImpl.create:"+name);
    }
}
