package com.example.spring.aop.service.impl;

import com.example.spring.aop.dao.IAopDao;
import com.example.spring.aop.service.IAopService;

/**
 * @program: spring-01 com.example.spring.aop.service.impl.AopServiceImpl
 * @description: aop service impl
 * @author: fate
 * @create: 2019-09-20 17:06
 **/
public class AopServiceImpl implements IAopService {

    IAopDao aopDao;

    public void setAopDao(IAopDao aopDao) {
        this.aopDao = aopDao;
    }

    @Override
    public void create(String name, int age) {
        System.out.println("AopServiceImpl.create");
        aopDao.create(name,age);

    }
}
