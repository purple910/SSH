package com.example.dao.impl;

import com.example.dao.BookCardDao;
import com.example.entity.BookCard;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

/**
 * @program: SSH-02 com.example.dao.impl.BookCardDao
 * @description:
 * @author: fate
 * @create: 2019-10-04 16:59
 **/
public class BookCardDaoImpl implements BookCardDao {
    //在SSH的设计理念：要使用某个实例，那么就定义声明一个对象，然后
    //给它添加set方法（用于spring注入进来）
    //实现不要关注这个实例来自于那里，以及怎么创建，或者它是谁
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession(){
        //sessionFactory这个实例可以自己按常规的hibernate传统写法创建
        //也可以交给spring去托管
        Configuration cfg = new Configuration().configure();
        sessionFactory = cfg.buildSessionFactory();
        //获取session
        Session session = sessionFactory.openSession();
        return session;
    }

    @Override
    public List<BookCard> getAllBookCard() {
        Session session = getSession();

        //后面当使用JPA的时候，EntityManager 类似于 Session
        Query<BookCard> query = session.createQuery("from BookCard");

        //将所有的数据查询出来并放到List集合里
        List<BookCard> list = query.getResultList();
        //将集合遍历循环
        for(BookCard bookCard:list){
            //打印输出到控制台
            System.out.println(bookCard);        }

        //关闭session
        session.close();
        //关闭sessionFactory
        sessionFactory.close();
        //返回list集合
        return list;
    }

    @Override
    public void addBookCard(BookCard bookCard) {
        System.out.println("BookCardDaoImpl.addBookCard");
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Serializable save = session.save(bookCard);
        System.out.println(save);
        transaction.commit();
        session.close();
    }
}
