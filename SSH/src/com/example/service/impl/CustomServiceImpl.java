package com.example.service.impl;

import com.example.dao.CustomDao;
import com.example.dao.OrderDao;
import com.example.dao.impl.CustomDaoImpl;
import com.example.dao.impl.OrderDaoImpl;
import com.example.entity.CustomEntity;
import com.example.service.CustomService;

import java.io.Serializable;
import java.util.List;

/**
 * @program: hibernate com.CustomServiceImpl
 * @description:
 * @author: fate
 * @create: 2019-10-12 10:28
 **/
public class CustomServiceImpl implements CustomService {

    private CustomDao customDao;
    private OrderDao orderDao ;

    public CustomDao getCustomDao() {
        return customDao;
    }

    public void setCustomDao(CustomDao customDao) {
        this.customDao = customDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Serializable addCustom(CustomEntity entity) {
        if(entity.getId()==0){
            return 0;
        }
        Serializable serializable = customDao.addCustom(entity);
        return serializable;
    }

    @Override
    public Serializable deleteCustom(CustomEntity entity) {
        if(customDao.queryCustomById(entity.getId())!=null){
            customDao.deleteCustom(entity);
            return 1;
        }
        return 0;
    }

    @Override
    public Serializable updateCustom(CustomEntity entity) {
        if(customDao.queryCustomById(entity.getId())!=null){
            customDao.updateCustom(entity);
            return 1;
        }
        return 0;
    }

    @Override
    public CustomEntity queryCustomById(int id) {
        return customDao.queryCustomById(id);
    }

    @Override
    public List<CustomEntity> queryCustomAll() {
        return customDao.queryCustomAll();
    }

    @Override
    public CustomEntity queryCustomByOrder(int id) {
        if (orderDao.queryOrderById(id)!=null){
            CustomEntity customEntity = customDao.queryCustomByOrder(id);
            return customEntity;
        }
        return null;
    }

}
