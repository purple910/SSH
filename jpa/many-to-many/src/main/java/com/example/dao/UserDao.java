package com.example.dao;

import com.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: jpa com.example.dao.UserDao
 * @description:
 * @author: fate
 * @create: 2019-10-19 11:32
 **/
public interface UserDao extends JpaSpecificationExecutor<User>, JpaRepository<User,Long> {

}
