package com.example.test;

import com.example.dao.LinkManDao1;
import com.example.domain.LinkMan;
import com.example.dao.CustomDao1;
import com.example.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @program: jpa Main
 * @description:
 * @author: fate
 * @create: 2019-10-19 09:59
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class Main {

    @Autowired
    private CustomDao1 customDao;

    @Autowired
    private LinkManDao1 linkManDao;

    @Test
    @Transactional
    @Rollback(value = false)
    public void test(){
        Customer customer = new Customer();
        customer.setName("百度");

        LinkMan linkMan = new LinkMan();
        linkMan.setName("效力");
        LinkMan linkMan1 = new LinkMan();
        linkMan1.setName("物质");

        /**
         * 本质是update
         * 需要一的一方拥有维护权
         */
//        customer.getLinkManSet().add(linkMan);
//        customDao.save(customer);
//        linkManDao.save(linkMan);

//        Set<LinkMan> set = new HashSet<>();
//        set.add(linkMan);set.add(linkMan1);
//        customer.setLinkManSet(set);
//        customDao.save(customer);
//        linkManDao.save(linkMan);
//        linkManDao.save(linkMan1);

        /**
         * 本质是insert(一对一的添加)
         */
//        linkMan.setCustomer(customer);
//        customDao.save(customer);
//        linkManDao.save(linkMan);


        /**
         * 组合插入
         */
        Set<LinkMan> set = new HashSet<>();
        set.add(linkMan1);set.add(linkMan);

        linkMan.setCustomer(customer);
        linkMan1.setCustomer(customer);
        customer.setLinkManSet(set);

        customDao.save(customer);
        linkManDao.save(linkMan);
        linkManDao.save(linkMan1);
    }



    @Test
    @Transactional
    @Rollback(value = false)
    public void TestjilianSave(){
        Customer customer = new Customer();
        customer.setName("苹果");

        LinkMan linkMan = new LinkMan();
        linkMan.setName("天下");
        LinkMan linkMan1 = new LinkMan();
        linkMan1.setName("永生");

        Set<LinkMan> set = new HashSet<>();
        set.add(linkMan1);set.add(linkMan);

        linkMan.setCustomer(customer);
        linkMan1.setCustomer(customer);
        customer.setLinkManSet(set);

        customDao.save(customer);

    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void Testjiliandelete(){
        Optional<Customer> customer = customDao.findById(27L);
        Customer entity = customer.get();
        customDao.delete(entity);

    }
}
