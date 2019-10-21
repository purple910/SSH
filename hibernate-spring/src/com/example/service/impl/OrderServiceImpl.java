package com.example.service.impl;

import com.example.dao.CustomDao;
import com.example.dao.OrderDao;
import com.example.dao.impl.CustomDaoImpl;
import com.example.dao.impl.OrderDaoImpl;
import com.example.entity.CustomEntity;
import com.example.entity.OrderEntity;
import com.example.service.OrderService;

import java.io.Serializable;
import java.util.List;

/**
 * @program: hibernate com.example.service.impl.OrderServiceImpl
 * @description:
 * @author: fate
 * @create: 2019-10-12 10:29
 **/
public class OrderServiceImpl implements OrderService {

    private CustomDao customDao;
    private OrderDao orderDao  ;

    public void setCustomDao(CustomDao customDao) {
        this.customDao = customDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Serializable addOrder(OrderEntity entity) {
        if (orderDao.queryOrderById(entity.getId())!=null){
            return 0;
        }
        Serializable addOrder = orderDao.addOrder(entity);
        return addOrder;
    }

    @Override
    public int deleteOrder(OrderEntity entity) {
        if (orderDao.queryOrderById(entity.getId())!=null){
            orderDao.deleteOrder(entity);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateOrder(OrderEntity entity) {
        if (orderDao.queryOrderById(entity.getId())!=null){
            orderDao.updateOrder(entity);
            return 1;
        }
        return 0;
    }

    @Override
    public OrderEntity queryOrderById(int id) {
        return orderDao.queryOrderById(id);
    }

    @Override
    public List<OrderEntity> queryOrderByCustom(CustomEntity entity) {
        if (customDao.queryCustomById(entity.getId())!=null){
            List<OrderEntity> orderEntities = orderDao.queryOrderByCustom(entity.getId());
            return orderEntities;
        }
        return null;
    }
}
