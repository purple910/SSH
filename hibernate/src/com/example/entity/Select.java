package com.example.entity;

import java.util.ArrayList;import com.example.entity.TestEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @program: hibernate-01 PACKAGE_NAME
 * @description: 查询方式
 * @author: fate
 * @create: 2019-09-16 20:20
 **/
public class Select {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(String[] args) {
        /**
         * HQL
         * query
         */
//        List<TestEntity> entities = query1();
//        System.out.println(entities);

//        query2(12);

        /**
         *Criteria对象
         *
         */
//        query3();
//        query4(12);

        /**
         * SQLQuery对象查询
         */
//        query5();
//        query6(12);

        /**
         * get load
         */
//        query7();
//        query8();
    }

    public static List<TestEntity> query1(){
        Session session = getSession();
//        Query query = session.createQuery("select t from TestEntity as t");
        Query query = session.createQuery("from TestEntity as t where t.age>12");
        List<TestEntity> list = query.list();
        session.close();
        return list;
    }

    public static void query2(int a){
        Session session = getSession();
        Query query = session.createQuery("from TestEntity as t where t.age > :a");
//        query.setInteger("a",a);
        query.setParameter("a",a);
        List<TestEntity> list = query.list();

        session.close();
        System.out.println(list);
    }

    public static void query3(){
        Session session = getSession();
        Criteria criteria = session.createCriteria(TestEntity.class);
        List<TestEntity> list = criteria.list();
        System.out.println(list);
        session.close();
    }

    public static void query4(int id){
        Session session = getSession();
        Criteria criteria = session.createCriteria(TestEntity.class);
        criteria.add(Restrictions.eq("age",11));
        List<TestEntity> list = criteria.list();
        System.out.println(list);
        session.close();
    }

    public static void query5(){
        Session session = getSession();
        String sql = "select* from test";
        NativeQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(TestEntity.class);
        List<TestEntity> list = sqlQuery.list();
        System.out.println(list);
        session.close();
    }

    public static void query6(int a){
        Session session = getSession();
        String sql = "select* from test where age > :age";
        NativeQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setParameter("age",a);
        sqlQuery.addEntity(TestEntity.class);
        List<TestEntity> list = sqlQuery.list();
        System.out.println(list);
        session.close();
    }

    public static void query7(){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        TestEntity entity = session.get(TestEntity.class, 1);
        System.out.println(entity);
        transaction.commit();
        session.close();
    }

    public static void query8(){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        TestEntity load = session.load(TestEntity.class, 5);
        System.out.println(load);
        transaction.commit();
        session.close();
    }
}
