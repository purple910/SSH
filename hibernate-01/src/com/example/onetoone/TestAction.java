package com.example.onetoone;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * @program: hibernate-01 com.example.onetoone
 * @description: 测试one-to-one
 * @author: fate
 * @create: 2019-09-18 17:14
 **/
public class TestAction {
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
         * 同增
         */
//        PersonEntity person = new PersonEntity();
//        person.setPname("xyxyxy");
//        person.setPid("2");
//        CardEntity card = new CardEntity();
//        card.setCid("2");
//        card.setCnum("21212121");
//
//        //主表包含子表
//        //主表为person 子表为card
//        person.setCard(card);
//
//        saved(person);


        /**
         * 同改
         */
//        PersonEntity personEntity = new PersonEntity("1","Tom");
//        CardEntity cardEntity = new CardEntity("1","0000000");
//
//        personEntity.setCard(cardEntity);
//        updated(personEntity);


        /**
         * 同删
         */
//        PersonEntity personEntity = new PersonEntity();
//        personEntity.setPid("1");
//        CardEntity cardEntity = new CardEntity();
//        cardEntity.setCid("1");
//
//        personEntity.setCard(cardEntity);
//        deleted(personEntity);


        /**
         * merge
         * 不能建立联系，只能操作一张独立表
         */
//        merged();


        /**
         * 同查
         */


    }



    public static void deleted(PersonEntity personEntity){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(personEntity);
        transaction.commit();
        session.close();
    }

    public static void updated(PersonEntity personEntity){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(personEntity);
        transaction.commit();
        session.close();
    }

    public static void saved(PersonEntity personEntity){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(personEntity);
//        session.save(personEntity);

        transaction.commit();
        session.close();
    }

    public static void merged(){
        CardEntity cardEntity = new CardEntity();
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        cardEntity.setCid("11");
        cardEntity.setCnum("2232323");
        session.merge(cardEntity);
        transaction.commit();
        session.clear();
        session.close();
    }
}
