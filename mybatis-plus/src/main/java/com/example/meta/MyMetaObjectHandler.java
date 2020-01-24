package com.example.meta;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @program: mybatis-plus-01 com.example.meta.MyMetaObjectHandler
 * @description: 元数据 设置默认值 java bean 的属性
 * @author: fate
 * @create: 2019-10-12 20:12
 **/
public class MyMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("MyMetaObjectHandler.insertFill");
        this.setInsertFieldValByName("stuName","Salary",metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("MyMetaObjectHandler.updateFill");
        //@since 快照：3.0.7.2-SNAPSHOT， @since 正式版暂未发布3.0.7
        this.setUpdateFieldValByName("stuName", "Tom", metaObject);
    }
}
