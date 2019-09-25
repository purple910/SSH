package com.example.spring.ios.service.iml;

import com.example.spring.ios.dao.IIocDao;
import com.example.spring.ios.service.IIocService;

import java.util.List;
import java.util.Map;

/**
 * @program: spring-01 com.example.spring.service
 * @description: ioc
 * @author: fate
 * @create: 2019-09-19 10:33
 **/
public class IocServiceImpl implements IIocService {

    private String userName;
    private IIocDao iIocDao;
    private List list;
    private Map map;

    public void setMap(Map map) {
        this.map = map;
    }

    public void setList(List list) {
        this.list = list;
    }

    public IocServiceImpl(){}

//    public IocServiceImpl(IIocDao iocDao){
//        this.iIocDao=iocDao;
//        System.out.println("IocServiceImpl.IocServiceImpl");
//    }
//
//    public IocServiceImpl(IIocDao iocDao,String userName){
//        this.iIocDao=iocDao;
//        this.userName=userName;
//        System.out.println("iocDao = [" + iocDao + "], userName = [" + userName + "]");
//    }

    public void setiIocDao(IIocDao iIocDao) {
        this.iIocDao = iIocDao;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void create(String userName, int age){
        System.out.println("list = " + this.list);
        System.out.println("map = " + this.map);
        iIocDao.created(this.userName,age);
    }


//    public IocServiceImpl(){
//        System.out.println("IocServiceImpl.IocServiceImpl");
//    }


//    public void init(){
//        System.out.println("IocServiceImpl.init");
//    }

//    public void destroy(){
//        System.out.println("IocServiceImpl.destroy");
//    }

}
