package com.example.test;

import com.example.domain.Customer;
import com.example.utils.JpaUtils;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @program: jpa-01 com.JpqlTest
 * @description:
 * @author: fate
 * @create: 2019-10-14 19:10
 **/
public class JpqlTest {

    @Test
    public void testFindAll(){
        EntityManager manager = JpaUtils.getManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Query query = manager.createQuery("from Customer ");
        List<Customer> list = query.getResultList();
        System.out.println("list = " + list);

        transaction.commit();
        manager.close();
    }

    @Test
    public void testOrder(){
        EntityManager manager = JpaUtils.getManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Query query = manager.createQuery("from Customer order by id desc ");
        List<Customer> list = query.getResultList();
        System.out.println("list = " + list);

        transaction.commit();
        manager.close();
    }

    @Test
    public void testCount(){
        EntityManager manager = JpaUtils.getManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Query query = manager.createQuery("select count(id) from Customer ");
        Object result = query.getSingleResult();
        System.out.println("result = " + result);

        transaction.commit();
        manager.close();
    }

    @Test
    public void testPage(){
        EntityManager manager = JpaUtils.getManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Query query = manager.createQuery("select s from Customer s ");
        query.setFirstResult(0);
        query.setMaxResults(2);
        List resultList = query.getResultList();

        System.out.println("resultList = " + resultList);

        transaction.commit();
        manager.close();
    }

    @Test
    public void testLike(){
        EntityManager manager = JpaUtils.getManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Query query = manager.createQuery("from Customer where name like :name");
        query.setParameter("name","%i%");
        List resultList = query.getResultList();

        System.out.println("resultList = " + resultList);

        transaction.commit();
        manager.close();
    }


}
