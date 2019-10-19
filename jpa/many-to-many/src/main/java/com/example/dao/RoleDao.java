package com.example.dao;

import com.example.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: jpa com.example.dao.RoleDao
 * @description:
 * @author: fate
 * @create: 2019-10-19 11:33
 **/
public interface RoleDao extends JpaRepository<Role,Long>, JpaSpecificationExecutor<Role> {

}
