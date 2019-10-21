package com.example.dao.impl;

import com.example.dao.OrderDao;
import com.example.entity.OrderEntity;
import com.example.util.DB;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

/**
 * @program: hibernate com.example.dao.impl.OrderDaoImpl
 * @description:
 * @author: fate
 * @create: 2019-10-12 10:01
 **/
public class OrderDaoImpl implements OrderDao {
    Session session = null;

    @Override
    public Serializable addOrder(OrderEntity entity){
        session = DB.getSession();
        Transaction transaction = session.beginTransaction();
        Serializable save = session.save(entity);
        transaction.commit();
        session.close();
        return save;
    }

    @Override
    public void deleteOrder(OrderEntity entity){
        session = DB.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateOrder(OrderEntity entity){
        session = DB.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public OrderEntity queryOrderById(int id){
        session = DB.getSession();
        OrderEntity entity = session.get(OrderEntity.class, id);
        session.close();
        return entity;
    }

    @Override
    public List<OrderEntity> queryOrderByCustom(int oid){
        session = DB.getSession();
        Query query = session.createQuery("from OrderEntity where custom.id=:id");
        query.setParameter("id",oid);
        List<OrderEntity> list = query.list();
        session.close();
        return list;
    }
}
