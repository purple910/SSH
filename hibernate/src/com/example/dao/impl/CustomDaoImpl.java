package com.example.dao.impl;

import com.example.dao.CustomDao;
import com.example.entity.CustomEntity;
import com.example.util.DB;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

/**
 * @program: hibernate com.example.dao.impl.CustomDaoImpl
 * @description:
 * @author: fate
 * @create: 2019-10-12 10:00
 **/
public class CustomDaoImpl implements CustomDao {

    Session session = null;


    @Override
    public Serializable addCustom(CustomEntity entity) {
        session = DB.getSession();
        Transaction transaction = session.beginTransaction();
        Serializable save = session.save(entity);
        transaction.commit();
        System.out.println(save);
        return save;
    }

    @Override
    public void deleteCustom(CustomEntity entity) {
        session = DB.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateCustom(CustomEntity entity) {
        session = DB.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public CustomEntity queryCustomById(int id) {
        session = DB.getSession();
        CustomEntity customEntity = session.get(CustomEntity.class, id);
        session.close();
        return customEntity;
    }

    @Override
    public CustomEntity queryCustomByOrder(int id) {
        session = DB.getSession();
        Query query = session.createQuery("select c from CustomEntity as c inner join OrderEntity as o on c.id=o.custom.id where o.id=:id");
        query.setParameter("id",id);
        List<CustomEntity> list = query.list();
        session.close();
        return list.get(0);
    }
}
