package com.example.test;

import com.example.entity.CustomEntity;
import com.example.entity.OrderEntity;
import com.example.service.CustomService;
import com.example.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {



    @Test
    public void main() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml" );

        CustomService customService = applicationContext.getBean("customService", CustomService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        //同增
//        Set<OrderEntity> emp = new HashSet<OrderEntity>();
//        CustomEntity customEntity = new CustomEntity("a","123123","李四","123456789","bj");
//        OrderEntity orderEntity = new OrderEntity("苹果",5.5,30);
//        orderEntity.setCustom(customEntity);
//        emp.add(orderEntity);
//        customEntity.setOrders(emp);
//        Serializable serializable = customService.addCustom(customEntity);
//        System.out.println("serializable = " + serializable);


        //Customer
//        CustomEntity customEntity = new CustomEntity("b","asdf","张三","123456789","xa");
//        Serializable serializable = customService.addCustom(customEntity);
//        System.out.println("serializable = " + serializable);

        //order
//        OrderEntity orderEntity = new OrderEntity("香蕉",12.5,5);
//        orderEntity.setCustom(new CustomEntity(12));
//        Serializable addOrder = orderService.addOrder(orderEntity);
//        System.out.println("addOrder = " + addOrder);



//
//        Set<OrderEntity> emp = new HashSet<OrderEntity>();
//        CustomEntity customEntity = new CustomEntity("abcd","123123","李四","123456789","北京");
//        customEntity.setId(12);
//        OrderEntity orderEntity = new OrderEntity(13,"苹果666",666,2);
//        OrderEntity orderEntity1 = new OrderEntity(14,"香蕉666",888,2);
//        orderEntity.setCustom(customEntity);orderEntity1.setCustom(customEntity);
//        emp.add(orderEntity);emp.add(orderEntity1);
//        customEntity.setOrders(emp);
//        Serializable serializable = customService.updateCustom(customEntity);
//        System.out.println("serializable = " + serializable);


        //Customer
//        CustomEntity customEntity = new CustomEntity("hibernate","asdf","张三","123456789","xa");
//        customEntity.setId(13);
//        Serializable serializable = customService.updateCustom(customEntity);
//        System.out.println("serializable = " + serializable);

        //order
//        OrderEntity orderEntity = new OrderEntity(14,"饺子1231",12.5,5);
//        orderEntity.setCustom(new CustomEntity(12));
//        Serializable addOrder = orderService.updateOrder(orderEntity);
//        System.out.println("addOrder = " + addOrder);




        //order
//        CustomEntity customEntity1 = customService.queryCustomByOrder(13);
//        System.out.println("customEntity1 = " + customEntity1);

        //custom
//        List<OrderEntity> orderEntities = orderService.queryOrderByCustom(new CustomEntity(12));
//        System.out.println("orderEntities = " + orderEntities);


        //同删
//        CustomEntity entity = customService.queryCustomById(12);
//        Serializable serializable = customService.deleteCustom(entity);
//        System.out.println("serializable = " + serializable);

        //单删customer
//        Serializable serializable = customService.deleteCustom(new CustomEntity(8));
//        System.out.println("serializable = " + serializable);
//
//        //order
        int i = orderService.deleteOrder(new OrderEntity(2));
        System.out.println("i = " + i);



    }



}
