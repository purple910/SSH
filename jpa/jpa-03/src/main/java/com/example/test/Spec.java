package com.example.test;

import com.example.dao.CustomDao;
import com.example.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @program: jpa com.example.test.Spec
 * @description:
 * @author: fate
 * @create: 2019-10-18 21:57
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-config.xml")
public class Spec {

    @Autowired
    private CustomDao customDao;

    @Test
    public void test1(){

        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //获取比较的属性
                Path<Object> name = root.get("name");
                //构造查询条件
                Predicate predicate = criteriaBuilder.equal(name, "zs");
                return predicate;
            }
        };

        Optional<Customer> one = customDao.findOne(specification);
        System.out.println("one = " + one);
    }

    @Test
    public void test2(){

        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                Path<Object> name = root.get("name");
                Path<Object> industry = root.get("industry");

                Predicate predicate = criteriaBuilder.equal(name, "zs");
                Predicate equal = criteriaBuilder.equal(industry, "aaaa");
                Predicate and = criteriaBuilder.and(predicate, equal);

                return and;
            }
        };

        Optional<Customer> one = customDao.findOne(specification);
        System.out.println("one = " + one);
    }

    @Test
    public void test3(){

        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                Path<Object> name = root.get("name");

                Predicate like = criteriaBuilder.like(name.as(String.class), "%s%");

                return like;
            }
        };

        List<Customer> all = customDao.findAll(specification);
        System.out.println("all = " + all);
    }

    @Test
    public void test4(){

        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                Path<Object> name = root.get("name");

                Predicate like = criteriaBuilder.like(name.as(String.class), "%s%");

                return like;
            }
        };
        List<String> list = new ArrayList<>();
        list.add("id");
        Sort sort;
        sort = new Sort(Sort.Direction.DESC,list);

        List<Customer> all = customDao.findAll(specification,sort);
        System.out.println("all = " + all);
    }

    @Test
    public void test5(){

        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {


                return null;
            }
        };

        Pageable pageable = new PageRequest(0,2);
        Page<Customer> all = customDao.findAll(specification, pageable);
        System.out.println("all = " + all.getContent());
    }



}
