package com.example.demo.controller;


import com.example.demo.factory.RubricBean;
import com.example.demo.factory.StudentBean;
import com.example.demo.service.StudentServiceImpl;
import org.omg.CORBA.MARSHAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;



    @RequestMapping("/student")
    public String ch1(){
        return "student";
    }

    @RequestMapping(value = "/student/rubric")
    public Map<String,Object> rubric(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<RubricBean> rubricBeans = studentService.queryRubricInfo(0, 5);
        map.put("list",rubricBeans);
        return map;
    }

    @RequestMapping(value = "/student/info")
    public Map<String,Object> info(HttpSession session){
        String name = (String) session.getAttribute("name");
        Map<String,Object> map = new HashMap<String, Object>();
        StudentBean studentBean = studentService.queryStudentInfo(name);
        map.put("info",studentBean);
        return map;
    }




}
