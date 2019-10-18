package com.example.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @program: hibernate com.DB
 * @description: db
 * @author: fate
 * @create: 2019-10-12 09:58
 **/
public class DB {
    //在SSH的设计理念：要使用某个实例，那么就定义声明一个对象，然后
    //给它添加set方法（用于spring注入进来）
    //实现不要关注这个实例来自于那里，以及怎么创建，或者它是谁
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public  Session getSession(){
        //sessionFactory这个实例可以自己按常规的hibernate传统写法创建
        //也可以交给spring去托管
        Configuration cfg = new Configuration().configure();
        sessionFactory = cfg.buildSessionFactory();
        //获取session
        Session session = sessionFactory.openSession();
        return session;
    }

}
