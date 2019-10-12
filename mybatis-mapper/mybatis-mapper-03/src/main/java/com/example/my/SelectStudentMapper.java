package com.example.my;

import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * @program: mybatis-mapper com.example.my.SelectAllMapper
 * @description:
 * @author: fate
 * @create: 2019-10-12 23:38
 **/
@RegisterMapper
public interface SelectStudentMapper<T> {

    /**
     * 查询全部结果
     *
     * @return
     */
    @SelectProvider(type = MySelectProvider.class, method = "dynamicSQL")
    List<T> selectStudent();
}
