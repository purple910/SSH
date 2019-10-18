package com.example.dao;

import com.example.entity.OrderEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @program: hibernate com.example.dao.Order
 * @description:
 * @author: fate
 * @create: 2019-10-12 10:01
 **/
public interface OrderDao {
    public Serializable addOrder(OrderEntity entity);
    public void deleteOrder(OrderEntity entity);
    public void updateOrder(OrderEntity entity);
    public OrderEntity queryOrderById(int id);
    public List<OrderEntity> queryOrderAll();
    public List<OrderEntity> queryOrderByCustom(int oid);
}
