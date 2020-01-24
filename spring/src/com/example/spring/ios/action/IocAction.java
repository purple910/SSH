package com.example.spring.ios.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring-01 com.example.spring.action
 * @description: login
 * @author: fate
 * @create: 2019-09-19 10:32
 **/
public class IocAction {

    public static void main(String[] args) {


//        System.out.println();//sout
//        System.out.println("iocService = " + iocService);//soutv
//        System.out.println("IocAction.main");//soutm
//        System.out.println("args = [" + args + "]");//soutp
//        System.out.printf("");//souf

        /**
         * 1.普通模式
         * IocServiceImpl
         * (IIocService)
         */
//        IocServiceImpl iocService = new IocServiceImpl();
//        iocService.create("ls",18);

        /**
         * 2.工厂模式
         * IocServiceImpl
         * IIocService
         * IocFactory
         */
//        IIocService iocService = IocFactory.getService();
//        iocService.create("zs",15);

        /**
         * 3.ioc
         * 控制反转
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println("--------------------");

//        IIocService iocService = (IIocService) context.getBean("iocService");
//        iocService.create("Tom",51);
//        IIocDao iocDao = (IIocDao) context.getBean("iocDao");

//        IIocService service = (IIocService) context.getBean("service");
//        service.create("bbb",12);
//
//        IIocDao dao = (IIocDao) context.getBean("dao");
//        dao.created("aaaaa",45454);

        final boolean flag = context.isSingleton("iocService");
        System.out.println(flag);
        final boolean b = context.isPrototype("iocService");
        System.out.println(b);
    }
}
