package com.example.spring.jdbc.service.impl;

import com.example.spring.jdbc.dao.JdbcDao;
import com.example.spring.jdbc.service.JdbcServicen;

/**
 * @program: spring-01 com.example.spring.jdbc.service.impl.JdbcServiceImpl
 * @description: jdbc impl service
 * @author: fate
 * @create: 2019-09-21 11:49
 **/
public class JdbcServiceImpl implements JdbcServicen {
    private JdbcDao jdbcDao;

    public void setJdbcDao(JdbcDao jdbcDao) {
        this.jdbcDao = jdbcDao;
    }

    @Override
    public void execute() {
        System.out.println("JdbcServiceImpl.execute");
        jdbcDao.execute();
    }
}
