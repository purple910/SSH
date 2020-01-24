package com.example.entity;

import com.example.entity.TestEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @program: hibernate-01 PACKAGE_NAME
 * @description: 缓存
 * @author: fate
 * @create: 2019-09-18 22:00
 **/
public class Test {



    public static void main(String[] args) {
        TestEntity testEntity = gets(1);
        System.out.println(testEntity);

    }


    public static final TestEntity gets(int id){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session session = sf.openSession();
        TestEntity entity = session.get(TestEntity.class, id);
        session.close();
        return entity;

    }
}
