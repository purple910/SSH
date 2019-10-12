package com.example.text;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.AR;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @program: mybatis-plus-01 com.example.text.AR
 * @description:
 * @author: fate
 * @create: 2019-10-10 22:11
 **/
public class ARText {
    private static final ClassPathXmlApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    public static void main(String[] args) {
        //IOC容器中
//        AR ar = new AR("aa",33);
//        ar.insert();

        AR ar = new AR();
        QueryWrapper<AR> wrapper = new QueryWrapper<>();
//        wrapper.like("stu_name","o");
        wrapper.lambda().like(AR::getStuName,"o");
        List<AR> ars = ar.selectList(wrapper);
        System.out.println("ars = " + ars);



    }
}
