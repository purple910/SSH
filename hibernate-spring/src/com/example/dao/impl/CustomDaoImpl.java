package com.example.dao.impl;

import com.example.dao.CustomDao;
import com.example.entity.CustomEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * @program: hibernate com.example.dao.impl.CustomDaoImpl
 * @description:
 * @author: fate
 * @create: 2019-10-12 10:00
 **/
public class CustomDaoImpl extends HibernateDaoSupport implements CustomDao {


    @Override
    public Serializable addCustom(CustomEntity entity) {
        Session session = this.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Serializable save = session.save(entity);
        transaction.commit();
        session.close();
        return save;
    }

    @Override
    public void deleteCustom(CustomEntity entity) {
        Session session = this.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateCustom(CustomEntity entity) {
        Session session = this.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public CustomEntity queryCustomById(int id) {
        Session session = this.getSessionFactory().openSession();
        CustomEntity customEntity = session.get(CustomEntity.class,id);
        session.close();
        return customEntity;
    }

    @Override
    public CustomEntity queryCustomByOrder(int id) {
        Session session = this.getSessionFactory().openSession();
        Query query = session.createQuery("select c from CustomEntity as c inner join OrderEntity as o on c.id=o.custom.id where o.id=:id");
        query.setParameter("id",id);
        List<CustomEntity> list = query.list();
        session.close();
        return list.get(0);
    }
}
