package com.example.test;

import com.example.dao.CustomDao;
import com.example.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: jpa com.example.test.Jpql
 * @description:
 * @author: fate
 * @create: 2019-10-18 16:36
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class Jpql {

    @Autowired
    private CustomDao customDao;

    @Test
    @Transactional(readOnly = true)
    public void testFindJpql(){
        Customer list = customDao.findJpql(2L);
        System.out.println("list = " + list);
    }

    @Test
    public void testFindJpql1(){
        Customer list = customDao.findJpql1(3L);
        System.out.println("list = " + list);
    }

    @Test
    public void testFindJpql2(){
        Customer list = customDao.findJpql2(1L);
        System.out.println("list = " + list);
    }

    @Test
    public void testFindJpql3(){
        Customer list = customDao.findJpql3("li");
        System.out.println("list = " + list);
    }

    @Test
    public void testFindJpql4(){
        List<Customer> list = customDao.findJpq4("bj");
        System.out.println("list = " + list);
    }


    @Test
    @Transactional
    @Rollback(value = false)
    public void testupdate(){
        Customer customer = new Customer();
        customer.setId(2L);
        customer.setName("Salary");
        customDao.updateJpql(2L,"Salary");
    }



    @Test
    public void find1(){
        List<Customer> address = customDao.findByAddress("bj");
        System.out.println("address = " + address);
    }

    @Test
    public void query(){
        List<Customer> customers = customDao.queryByNameLike("%a%");
        System.out.println("customers = " + customers);
    }

    @Test
    public void delete(){
        customDao.deleteById(2L);
    }
}
