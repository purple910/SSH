package com.example.my;

import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;

/**
 * @program: mybatis-mapper com.example.my.MyMapper
 * @description:
 * @author: fate
 * @create: 2019-10-12 23:26
 **/
public interface MyMapper<T> extends BaseSelectMapper<T>, BaseDeleteMapper<T>,SelectStudentMapper<T> {
}
