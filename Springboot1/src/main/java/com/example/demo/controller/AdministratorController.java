package com.example.demo.controller;

import com.example.demo.factory.MotifyBean;
import com.example.demo.service.AdministratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.LazyContextVariable;
import org.thymeleaf.context.WebContext;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class AdministratorController {

    @Autowired
    AdministratorServiceImpl administratorService;


    @RequestMapping(value = "/admini", method = RequestMethod.GET)
    public String showGuestList(@RequestParam("name") String name,Model model) {
        System.out.println(model);
        System.out.println(name);
        model.addAttribute("guests", "123131");

        return "administrator";
    }


    @RequestMapping(value="/updateStudent", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateStudent (String name, String password, HttpSession session) {
    System.out.println(name+password);
        //int list = administratorService.updateStudentPassword(stu);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name",22);
        map.put("password",55);
        return map;
    }

    @RequestMapping(value = "/administrator/rule")
    public Map<String, Object> rule(MotifyBean bean){
        Map<String, Object> map = new HashMap<String, Object>();
        int i = administratorService.insertMotifyInfo(bean);
        if(i>0){
            map.put("temp","success");
        }else{
            map.put("temp","error");
        }
        return map;
    }

    @RequestMapping(value = "/administrator")
    public String getAdministrator(){
        return "administrator";
    }

    @RequestMapping(value = "/administrator/plan")
    public Map<String, Object> plan(){
        int[] list = administratorService.querySpeed();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list",list);
        return map;
    }

    @RequestMapping(value = "")
    public Map<String,Object> classfiy(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<String[]> list = administratorService.queryExcellte();
        map.put("items",list);
        return map;
    }
}
