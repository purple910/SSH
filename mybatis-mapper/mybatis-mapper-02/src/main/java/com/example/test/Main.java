package com.example.test;

import com.example.entity.Student;
import com.example.mapper.StudentMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @program: mybatis-plus-01 com.example.test.Main
 * @description:
 * @author: fate
 * @create: 2019-10-12 21:05
 **/
public class Main {
    private static final ClassPathXmlApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }
    public static StudentMapper getMapper(){
        return context.getBean("studentMapper", StudentMapper.class);
    }


    public static void main(String[] args) {
        StudentMapper mapper = getMapper();

        List<Student> students = mapper.selectAll();
        System.out.println("students = " + students);

//        Student student = mapper.selectByPrimaryKey(1);
//        System.out.println("student = " + student);

        //回写
//        Student student = new Student("zs", 22);
//        int insert = mapper.insert(student);
//        System.out.println("insert = " + insert);
//        System.out.println("student = " + student);


        /***
         * Selective: 对没有操作的值，不进行处理
         * 没有Selective: 对没有操作的值，默认为null
         * 在修改时，有区别可以稍改一些
         */
//        Student student = new Student();
//        student.setStuName("y");
        //INSERT INTO mybatis_mapper_student ( stu_no,stu_name,stu_age ) VALUES( ?,?,? )
//        mapper.insert(student);
        //INSERT INTO mybatis_mapper_student ( stu_no,stu_name ) VALUES( ?,? )
//        mapper.insertSelective(student);


        Student student = new Student();


    }
}
