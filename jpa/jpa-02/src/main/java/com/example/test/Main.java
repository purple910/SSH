package com.example.test;

import com.example.dao.CustomDao;
import com.example.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * @program: jpa com.example.test.Test
 * @description:
 * @author: fate
 * @create: 2019-10-14 20:41
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class Main {

    @Autowired
    private CustomDao customDao;

    @Test
    @Transactional(readOnly = true)
    public void testGetOne(){
        Customer one = customDao.getOne(2L);
        System.out.println("one = " + one);
    }

    @Test
    public void testSave(){
        Customer customer = new Customer();
        customer.setName("LS");
        customer.setAddress("bj");
        customer.setLevel("vip");
        customer.setPhone("120");
        customer.setSource("qt");
        customer.setIndustry("com");
        //主键回响
        Customer save = customDao.save(customer);
        System.out.println("save = " + save);
    }

    @Test
    public void testUpdate(){
        Customer customer = new Customer();
        customer.setId(6L);
        customer.setName("LS66");
        customer.setAddress("bj6");
        customer.setLevel("vip6");
        //全部更新
        Customer save = customDao.save(customer);
        System.out.println("save = " + save);
    }

}
