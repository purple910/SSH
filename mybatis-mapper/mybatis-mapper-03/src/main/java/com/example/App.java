package com.example;

import com.example.entity.MybatisMapperStudent;
import com.example.mapper.MybatisMapperStudentMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final ClassPathXmlApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }
    public static MybatisMapperStudentMapper getMapper(){
        return context.getBean("mybatisMapperStudentMapper", MybatisMapperStudentMapper.class);
    }


    public static void main( String[] args )
    {
        MybatisMapperStudentMapper mapper = getMapper();


//        List<MybatisMapperStudent> students = mapper.selectAll();
//        System.out.println("students = " + students);

        //qbc
//        Example example = new Example(MybatisMapperStudent.class);
//
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andGreaterThanOrEqualTo("stuNo",1).andLessThan("stuNo",5);
//
//        Example.Criteria criteria1 = example.createCriteria();
//        criteria1.andLike("stuName","%s%");
//
//        example.or(criteria1);  //默认第一次创建的在自己圣上
//        example.orderBy("stuNo").desc();
//
//        List<MybatisMapperStudent> students = mapper.selectByExample(example);
//        System.out.println("students = " + students);

        //自定义mapper
        List<MybatisMapperStudent> students = mapper.selectStudent();
        System.out.println("students = " + students);


    }
}
