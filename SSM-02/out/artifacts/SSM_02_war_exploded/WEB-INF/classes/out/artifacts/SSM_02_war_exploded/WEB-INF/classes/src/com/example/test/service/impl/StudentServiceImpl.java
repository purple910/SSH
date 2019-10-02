package com.example.test.service.impl;

import com.example.test.entity.Student;
import com.example.test.mapper.StudentMapper;
import com.example.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @program: SSM-02 com.example.test.service.impl.StudentServiceImpl
 * @description:
 * @author: fate
 * @create: 2019-10-01 21:26
 **/
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public Student queryStudentById(int id)  {
        //手动获取创建
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        StudentMapper bean = ac.getBean(StudentMapper.class);
        Student student1 = bean.queryStudentById(id);
        System.out.println(student1);

        Student student = studentMapper.queryStudentById(id);
        System.out.println(student);
        return student;
    }
}
