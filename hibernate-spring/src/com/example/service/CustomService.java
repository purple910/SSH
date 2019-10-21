package com.example.service;

import com.example.entity.CustomEntity;

import java.io.Serializable;

/**
 * @program: hibernate com.example.service.CustomService
 * @description:
 * @author: fate
 * @create: 2019-10-12 10:28
 **/
public interface CustomService {
    public Serializable addCustom(CustomEntity entity);
    public Serializable deleteCustom(CustomEntity entity);
    public Serializable updateCustom(CustomEntity entity);
    public CustomEntity queryCustomById(int id);
    public CustomEntity queryCustomByOrder(int id);
}
