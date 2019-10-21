package com.example.dao.impl;

import com.example.dao.OrderDao;
import com.example.entity.OrderEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * @program: hibernate com.example.dao.impl.OrderDaoImpl
 * @description:
 * @author: fate
 * @create: 2019-10-12 10:01
 **/
public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {


    @Override
    public Serializable addOrder(OrderEntity entity){
        Session session = this.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Serializable save = session.save(entity);
        transaction.commit();
        session.close();
        return save;
    }

    @Override
    public void deleteOrder(OrderEntity entity){
        Session session = this.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateOrder(OrderEntity entity){
        Session session = this.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public OrderEntity queryOrderById(int id){
        Session session = this.getSessionFactory().openSession();
        OrderEntity orderEntity = session.get(OrderEntity.class, id);
        session.close();
        return orderEntity;
    }

    @Override
    public List<OrderEntity> queryOrderByCustom(int oid){
        Session session = this.getSessionFactory().openSession();
        Query query = session.createQuery("from OrderEntity where custom.id=:id");
        query.setParameter("id",oid);
        List list = query.list();
        session.close();
        return list;
    }
}
