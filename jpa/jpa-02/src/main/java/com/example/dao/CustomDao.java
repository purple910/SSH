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



    @Query(value = "from Customer where id = ?1 ")
    public Customer findJpql( Long id);

    @Query(value = "from Customer where id = :id ")
    public Customer findJpql1(@Param("id") Long id);
    @Query(value = "from Customer where address = ?1 ")
    public List<Customer> findJpq4( String address);

    @Query(value = "update Customer set name = ?2 where id=?1")
    @Modifying
    public void updateJpql(Long id,String name);




    @Query(value = "select * from jpa_customer where id = ? ",nativeQuery = true)
    public Customer findJpql2(Long id);

    @Query(value = "select * from jpa_customer where name = ? ",nativeQuery = true)
    public Customer findJpql3(String name);


    /**
     * findBy+...
     * @param address
     * @return
     */
    public List<Customer> findByAddress(String address);

    public List<Customer> queryByNameLike(String name);

    public void deleteById(Long id);



}
