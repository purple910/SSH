package com.example.service;

import com.example.entity.CustomEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @program: hibernate com.CustomService
 * @description:
 * @author: fate
 * @create: 2019-10-12 10:28
 **/
public interface CustomService {
    public Serializable addCustom(CustomEntity entity);
    public Serializable deleteCustom(CustomEntity entity);
    public Serializable updateCustom(CustomEntity entity);
    public CustomEntity queryCustomById(int id);
    public List<CustomEntity> queryCustomAll();
    public CustomEntity queryCustomByOrder(int id);
}
