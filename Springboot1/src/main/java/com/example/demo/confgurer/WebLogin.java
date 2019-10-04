package com.example.demo.confgurer;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WebLogin implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object login = request.getSession().getAttribute("login");
        //request.getSession().removeAttribute("login");
        //System.out.println(login);
        if(login==null){
            request.setAttribute("msg","没有相应权限请先登陆");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return true;
        }
    }


}
