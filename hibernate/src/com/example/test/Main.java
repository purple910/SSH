package com.example.test;

import com.example.entity.CustomEntity;
import com.example.entity.OrderEntity;
import com.example.service.CustomService;
import com.example.service.OrderService;
import com.example.service.impl.CustomServiceImpl;
import com.example.service.impl.OrderServiceImpl;
import com.example.util.DB;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {


    public static void main(final String[] args) throws Exception {

        CustomService customService = new CustomServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        //同增
//        Set<OrderEntity> emp = new HashSet<OrderEntity>();
//        CustomEntity customEntity = new CustomEntity("a","123123","李四","123456789","bj");
//        OrderEntity orderEntity = new OrderEntity("饭",21.2,3);
//        emp.add(orderEntity);
//        customEntity.setOrders(emp);
//        Serializable serializable = customService.addCustom(customEntity);
//        System.out.println("serializable = " + serializable);


        //Customer
//        CustomEntity customEntity = new CustomEntity("b","asdf","张三","123456789","xa");
//        Serializable serializable = customService.addCustom(customEntity);
//        System.out.println("serializable = " + serializable);

        //order
//        OrderEntity orderEntity = new OrderEntity("饺子",12.5,5);
//        orderEntity.setCustom(new CustomEntity(5));
//        Serializable addOrder = orderService.addOrder(orderEntity);
//        System.out.println("addOrder = " + addOrder);




//        Set<OrderEntity> emp = new HashSet<OrderEntity>();
//        CustomEntity customEntity = new CustomEntity("abcd","123123","李四","123456789","北京");
//        customEntity.setId(5);
//        OrderEntity orderEntity = new OrderEntity(6,"米饭",666,2);
//        OrderEntity orderEntity1 = new OrderEntity(7,"饺子",888,2);
//        emp.add(orderEntity);emp.add(orderEntity1);
//        customEntity.setOrders(emp);
//        Serializable serializable = customService.updateCustom(customEntity);
//        System.out.println("serializable = " + serializable);


        //Customer
//        CustomEntity customEntity = new CustomEntity("hibernate","asdf","张三","123456789","xa");
//        customEntity.setId(6);
//        Serializable serializable = customService.updateCustom(customEntity);
//        System.out.println("serializable = " + serializable);

        //order
//        OrderEntity orderEntity = new OrderEntity(6,"饺子1231",12.5,5);
//        orderEntity.setCustom(new CustomEntity(5));
//        Serializable addOrder = orderService.updateOrder(orderEntity);
//        System.out.println("addOrder = " + addOrder);




        //order
//        CustomEntity customEntity1 = customService.queryCustomByOrder(6);
//        System.out.println("customEntity1 = " + customEntity1);

        //custom
//        List<OrderEntity> orderEntities = orderService.queryOrderByCustom(new CustomEntity(5));
//        System.out.println("orderEntities = " + orderEntities);


        //同删
//        CustomEntity entity = customService.queryCustomById(5);
//        Serializable serializable = customService.deleteCustom(entity);
//        System.out.println("serializable = " + serializable);

        //单删customer
        Serializable serializable = customService.deleteCustom(new CustomEntity(6));
        System.out.println("serializable = " + serializable);

        //order
        int i = orderService.deleteOrder(new OrderEntity(8));
        System.out.println("i = " + i);

    }

















}
