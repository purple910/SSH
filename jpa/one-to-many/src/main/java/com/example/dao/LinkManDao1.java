package com.example.dao;

import com.example.domain.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: jpa com.onetomany.dao.LinkManDao
 * @description:
 * @author: fate
 * @create: 2019-10-19 10:13
 **/
public interface LinkManDao1 extends JpaRepository<LinkMan,Long>, JpaSpecificationExecutor<LinkMan> {

}
