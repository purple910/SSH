package com.company.handler;

import com.company.entity.Dept;
import com.company.entity.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springMVC-02 com.company.handler.FormController
 * @description:
 * @author: fate
 * @create: 2019-10-02 10:17
 **/
@Controller
@RequestMapping("/FormController")
public class FormController {

    @RequestMapping("testForm")
    public String testForm(Model model){
        People people = new People();
        people.setName("Salary");
        people.setAge(18);
        people.setSex(false);

        List<String> stringList = new ArrayList<>();
        stringList.add("football");
        stringList.add("pingpong");
        people.setHobbis(stringList);
        List<String> arrayList = new ArrayList<>();
        arrayList.add("football");
        arrayList.add("pingpong");
        arrayList.add("backetball");

        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("3");
        people.setCourse(strings);
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("1","JAVAEE");
        hashMap.put("2","SpringMVC");
        hashMap.put("3","Mybatis");

        Dept dept = new Dept(1,"开发部");
        List<Dept> list2 = new ArrayList<Dept>();
        list2.add(dept);
        people.setDepts(list2);
        List<Dept> deptList = new ArrayList<Dept>();
        deptList.add(dept);
        deptList.add(new Dept(2,"销售部"));
        deptList.add(new Dept(3,"财务部"));

        people.setCity("bj");

        people.setHome("lu");
        List<String> list = new ArrayList<>();
        list.add("zj");
        list.add("cd");
        list.add("bj");
        list.add("lu");
        list.add("gz");

        //默认放在command
        model.addAttribute("people",people);
        model.addAttribute("arrayList",arrayList);
        model.addAttribute("hashMap",hashMap);
        model.addAttribute("deptList",deptList);
        model.addAttribute("list",list);
        return "test";
    }


    @RequestMapping(value = "testMenthod",method = RequestMethod.POST)
    public String testpost(){
        System.out.println("FormController.testpost");
        return "test-success";
    }
    @RequestMapping(value = "testMenthod",method = RequestMethod.GET)
    public String testget(){
        System.out.println("FormController.testget");
        return "test-success";
    }
    @RequestMapping(value = "testMenthod", method = RequestMethod.PUT)
    public String testput(){
        System.out.println("FormController.testput");
//        return "redirect:/view/test-success.jsp";
        return "test-success";
    }
    @RequestMapping(value = "testMenthod", method = RequestMethod.DELETE)
    public String testdelete(){
        System.out.println("FormController.testdelete");
//        return "redirect:/view/test-success.jsp";
        return "test-success";
    }
}
