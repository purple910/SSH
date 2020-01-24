package com.example.spring.ios.factory;

import com.example.spring.ios.service.IIocService;
import com.example.spring.ios.service.iml.IocServiceImpl;

/**
 * @program: spring-01 com.example.spring.factory
 * @description: factory
 * @author: fate
 * @create: 2019-09-19 10:38
 **/
public class IocFactory {

    public static IIocService getService(){
        return new IocServiceImpl();
    }

//    public IIocDao getServiceDao(){
//        return new IocDaoImpl();
//    }
}
