package com.example.test;

import com.example.dao.CustomDao1;
import com.example.dao.LinkManDao1;
import com.example.domain.Customer;
import com.example.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

/**
 * @program: jpa com.example.test.Query
 * @description:
 * @author: fate
 * @create: 2019-10-19 11:56
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class Query {

    @Autowired
    private CustomDao1 customDao;

    @Autowired
    private LinkManDao1 linkManDao;

    @Test
    @Transactional
    public void query1(){
        Customer customer = customDao.getOne(28L);
        Set<LinkMan> linkManSet = customer.getLinkManSet();
        System.out.println("linkManSet = " + linkManSet);
        System.out.println("customer = " + customer);
    }

    @Test
    @Transactional
    public void query2(){
        /**
         * 多-》一
         */
        Optional<Customer> byId = customDao.findById(28L);
        Customer customer = byId.get();
        Set<LinkMan> linkManSet = customer.getLinkManSet();
        System.out.println("linkManSet = " + linkManSet);
        System.out.println("customer = " + customer);
    }

    @Test
    @Transactional
    public void query3(){
        LinkMan one = linkManDao.getOne(24L);
        System.out.println("one = " + one);
        Customer customer = one.getCustomer();
        System.out.println("customer = " + customer);
    }
}
