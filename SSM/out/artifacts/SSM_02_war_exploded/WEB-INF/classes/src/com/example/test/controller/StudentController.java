package com.example.test.controller;

import com.example.test.entity.Student;
import com.example.test.mapper.StudentMapper;
import com.example.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @program: SSM-02 com.example.test.controller.StudentController
 * @description:
 * @author: fate
 * @create: 2019-10-01 21:27
 **/
@RequestMapping(value = "Student")
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "queryById/{id}")
    public String queryById(@PathVariable("id") int id , Map<String,Object> map){
//        System.out.println("id = " + id);
        Student student1 = studentService.queryStudentById(id);
//        System.out.println(student1);

        map.put("student",student1);
        return "success";
    }
}
