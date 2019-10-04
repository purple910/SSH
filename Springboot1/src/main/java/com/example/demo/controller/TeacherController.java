package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {

    @RequestMapping("/tacher/add")
    public String ch1(){
        return "tea_addq";
    }


    @RequestMapping("/teacher/query")
    public String ch2(){
        return "tea_question";
    }


}
