package com.example.spring.ios.dao.impl;

import com.example.spring.ios.dao.IIocDao;

/**
 * @program: spring-01 com.example.spring.dao.impl
 * @description: dao.impl
 * @author: fate
 * @create: 2019-09-19 11:35
 **/
public class IocDaoImpl implements IIocDao {
    private IIocDao iocDao;


    @Override
    public void created(String name, int age) {
        System.out.println("name = [" + name + "], age = [" + age + "]");
    }
}
