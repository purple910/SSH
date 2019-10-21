package com.example.dao;

import com.example.entity.CustomEntity;

import java.io.Serializable;

/**
 * @program: hibernate com.example.dao.Custom
 * @description:
 * @author: fate
 * @create: 2019-10-12 09:59
 **/
public interface CustomDao {
    public Serializable addCustom(CustomEntity entity);
    public void deleteCustom(CustomEntity entity);
    public void updateCustom(CustomEntity entity);
    public CustomEntity queryCustomById(int id);
    public CustomEntity queryCustomByOrder(int id);
}
