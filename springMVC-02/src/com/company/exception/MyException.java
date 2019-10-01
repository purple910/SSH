package com.company.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: springMVC-02 com.company.handler.MyExceptionHandler
 * @description: 代表这个类专门来处理异常
 * @author: fate
 * @create: 2019-10-01 14:35
 **/
@ControllerAdvice
public class MyException {

    @ExceptionHandler({ArithmeticException.class,IllegalStateException.class})
    public ModelAndView handlerArithmeticException(Exception e){    //只能包含异常
        ModelAndView view = new ModelAndView("error");
        System.out.println(e);
        view.addObject("error",e);
        return view;
    }
}
