package com.example.test;

import com.example.dao.RoleDao;
import com.example.dao.UserDao;
import com.example.domain.Role;
import com.example.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

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
    private RoleDao roleDao;
    @Autowired
    private UserDao userDao;

    @Test
    @Transactional
    @Rollback(false)
    public void test(){
        User user = new User();
        user.setUname("Tom");
        user.setUage(18);

        Role role = new Role();
        role.setRname("JAVA");

        /**
         * 不可以两方都有维护权
         * 被动的一方放弃
         */
        user.getRoles().add(role);
        role.getUsers().add(user);

        userDao.save(user);
        roleDao.save(role);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testJilianSave(){
        User user = new User();
        user.setUname("Tom");
        user.setUage(18);

        Role role = new Role();
        role.setRname("JAVA");


        user.getRoles().add(role);
        role.getUsers().add(user);

        userDao.save(user);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testJili7777777777anDelete(){
        User user = userDao.getOne(1L);
        userDao.delete(user);
    }


}
