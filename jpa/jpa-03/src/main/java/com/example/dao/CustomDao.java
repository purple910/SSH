package com.example.dao;

import com.example.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @program: jpa com.example.dao.CustomDao
 * @description:
 * @author: fate
 * @create: 2019-10-14 20:39
 **/
public interface CustomDao extends JpaRepository<Customer,Long> , JpaSpecificationExecutor<Customer> {


}
