package com.example.service;

import com.example.entity.CustomEntity;
import com.example.entity.OrderEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @program: hibernate com.example.service.OrderService
 * @description:
 * @author: fate
 * @create: 2019-10-12 10:29
 **/
public interface OrderService {
    public Serializable addOrder(OrderEntity entity);
    public int deleteOrder(OrderEntity entity);
    public int updateOrder(OrderEntity entity);
    public OrderEntity queryOrderById(int id);
    public List<OrderEntity> queryOrderByCustom(CustomEntity entity);
}
