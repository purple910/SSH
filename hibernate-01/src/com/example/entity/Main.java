package com.example.entity;

import com.example.entity.TestEntity;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Main {
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

    public static void main(final String[] args) throws Exception {
//       TestEntity entity = new TestEntity(21,"zs",18);
       TestEntity entity = new TestEntity("Salary",8);
       create(entity);

//        List<TestEntity> read = read();
//        System.out.println(read);

//        TestEntity entity = new TestEntity(1,"zs+++",18);
//        update(entity);

//        TestEntity entity = new TestEntity(1,"",1);
//        delete(entity);

//        TestEntity entity = get(6);
//        System.out.println(entity);

//        long count = count();
//        System.out.println(count);


//          从1开始，查3条
//        List<TestEntity> entities = queryPage(1, 3);
//        for (TestEntity entity:entities) {
//            System.out.println(entity);
//        }

        /**
         * 悲观锁
         */
//        gets();



    }

    private static final void gets(){
        Session session = getSession();
        session.get(TestEntity.class,1,LockMode.UPGRADE_SKIPLOCKED);
        session.close();
    }

    public static List<TestEntity> queryPage(int start,int end){
        Session session = getSession();
        Query query = session.createQuery("from TestEntity ");
        query.setFirstResult(start);
        query.setMaxResults(end);
        List<TestEntity> list = query.list();
        session.close();
        return list;
    }

    public static long count(){
        Session session = getSession();
        Query query = session.createQuery("select count(t) from TestEntity as t");
        long object = (long)query.uniqueResult();
        session.close();
        return object;
    }

    public static TestEntity get(int id){
        Session session = getSession();
        TestEntity entity = session.get(TestEntity.class, id);
        session.close();
        return entity;
    }

    public static void create(TestEntity entity){

        Session session = getSession();
        //开启时事务
        Transaction transaction = session.beginTransaction();
        Serializable save = session.save(entity);
        //事务回滚
        transaction.commit();
        session.close();
    }

    public static List<TestEntity> read(){
        Session session = getSession();
        Query query = session.createQuery("from TestEntity");
        List<TestEntity> list = query.list();
        session.close();
        return list;
    }

    public static void update(TestEntity entity){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    public static void delete(TestEntity entity){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }
}