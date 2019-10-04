package com.example.demo.controller;

import com.example.demo.factory.AdministratorBean;
import com.example.demo.factory.StudentBean;
import com.example.demo.factory.TeacherBean;
import com.example.demo.service.AdministratorServiceImpl;
import com.example.demo.service.StudentServiceImpl;
import com.example.demo.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class InitController {

    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    AdministratorServiceImpl administratorService;


    @RequestMapping("/index")
    public String hello(){
        return "index";
    }



    @GetMapping(value = "/user/login")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("people") String people, Map<String,Object> map, HttpSession session){
        if("student".equals(people)&&studentService.loginStudentMain(name,password)>0){
              session.setAttribute("login", name);
               return "redirect:/student.html";
        }else if("teacher".equals(people)&&teacherService.loginTeacherMain(name,password)>0){
                session.setAttribute("login", name);
                return "redirect:/teacher.html";

        }else if("administrator".equals(people)&&administratorService.loginAdministratorMain(name,password)>0){
                //System.out.println("0000");
                session.setAttribute("login",name);
                return "redirect:/administrator.html";
        }
        //System.out.println("44444");
        map.put("msg","有错");
        return "redirect:/index";
    }


}
