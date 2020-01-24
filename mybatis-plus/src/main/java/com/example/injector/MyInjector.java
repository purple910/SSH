package com.example.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.methods.*;
import com.example.injector.methods.MyDelete;
import com.example.mapper.StudentMapper;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @program: mybatis-plus-01 com.example.injector.methods.MyInjector
 * @description:
 * @author: fate
 * @create: 2019-10-11 23:13
 **/
public class MyInjector extends AbstractSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
//        return Stream.of(
//                new Insert(),
//                new Delete(),
//                new DeleteByMap(),
//                new DeleteById(),
//                new DeleteBatchByIds(),
//                new Update(),
//                new UpdateById(),
//                new SelectById(),
//                new SelectBatchByIds(),
//                new SelectByMap(),
//                new SelectOne(),
//                new SelectCount(),
//                new SelectMaps(),
//                new SelectMapsPage(),
//                new SelectObjs(),
//                new SelectList(),
//                new SelectPage(),
//                new MyDelete()
//        ).collect(toList());

        List<AbstractMethod> methodList = new DefaultSqlInjector().getMethodList(StudentMapper.class);
        methodList.add(new MyDelete());
        return methodList;
    }
}
