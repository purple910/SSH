package com.example.demo.confgurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebMvcConfg implements WebMvcConfigurer {


    //注册拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//           //SpringMVC下，拦截器的注册需要排除对静态资源的拦截(*.css,*.js)
//          //SpringBoot已经做好了静态资源的映射，因此我们无需任何操作
//              registry.addInterceptor(new WebLogin()).addPathPatterns("/**")
//                      .excludePathPatterns("/index.html","/","/user/login","/webjars/jquery/3.4.1/jquery.js");
//     }
    /**
     * 以前要访问一个页面需要先创建个Controller控制类，再写方法跳转到页面
     * 在这里配置后就不需要那么麻烦了，直接访问http://localhost:8080/toLogin就跳转到login.jsp页面了
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/error").setViewName("index");
        registry.addViewController("/teacher.html").setViewName("teacher");
        registry.addViewController("/student.html").setViewName("student");

        registry.addViewController("/administrator.html").setViewName("administrator");

    }
}