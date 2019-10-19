package com.example.test;

import com.example.domain.Customer;
import com.example.utils.JpaUtils;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * @program: jpa-01 JpaTest
 * @description:
 * @author: fate
 * @create: 2019-10-13 22:40
 **/
public class JpaTest {



    @Test
    public void testSave(){
        EntityManager manager = JpaUtils.getManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Customer customer = new Customer();
        customer.setName("真");
        customer.setIndustry("study");
        customer.setAddress("bj");
        //保存
        manager.persist(customer);

        transaction.commit();
        manager.close();

    }


    @Test
    public void testFind(){
        EntityManager manager = JpaUtils.getManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Customer customer = manager.find(Customer.class,1L);
        System.out.println("customer = " + customer);

        transaction.commit();
        manager.close();
    }

    @Test
    public void testReference(){
        EntityManager manager = JpaUtils.getManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Customer customer = manager.getReference(Customer.class,1L);
        System.out.println("customer = " + customer);

        transaction.commit();
        manager.close();
    }

    @Test
    public void testDelete(){
        EntityManager manager = JpaUtils.getManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Customer customer = manager.find(Customer.class, 1L);
        manager.remove(customer);

        transaction.commit();
        manager.close();
    }

    @Test
    public void testUpdate(){
        EntityManager manager = JpaUtils.getManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Customer customer =new Customer();
        customer.setIndustry("aaaa");
        customer.setId(3L);
        customer.setAddress("bj");
        customer.setName("zs");
        manager.merge(customer);

        transaction.commit();
        manager.close();
    }


}
