package com.aompany;

/**
 * @program: maven-4 com.aompany.Service
 * @description:
 * @author: fate
 * @create: 2019-10-08 11:44
 **/
public class Service {

    public static void add(){
        Dao dao = new Dao();
        dao.add();
        System.out.println("Service.add");
    }

//    public static void main(String[] args) {
//        add();
//    }
}
