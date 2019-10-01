package com.company.handler;

import com.company.exception.MyArrayIndexOutofBoundsException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @program: springMVC-02 com.company.handler.SecondSpringMVCHabdler
 * @description: 异常
 * @author: fate
 * @create: 2019-10-01 14:11
 **/
@Controller
@RequestMapping("second")
public class SecondSpringMVCHabdler  {

    @RequestMapping("exception")
    public String testException(){
        System.out.println(1/0);
        return "success";
    }

    /**
     * 用类自定义异常界面
     * @return
     * @throws MyArrayIndexOutofBoundsException
     */
    @RequestMapping("ArrayIndexException")
    public String ArrayIndexException() throws MyArrayIndexOutofBoundsException {
        if(1==1){
            throw new MyArrayIndexOutofBoundsException();
        }
        return "success";
    }

    /**
     * 用方法自定义异常界面
     * @return
     */
    @RequestMapping("ArrayIndex")
    public String ArrayIndex() {
        if(1==1){
            return "redirect:Status.form";
        }
        return "success";
    }
    @ResponseStatus(value = HttpStatus.CONFLICT , reason = "数组越界111111")
    @RequestMapping("Status")
    public String Status()  {
        return "error";
    }


    /**
     * 可以捕获本类中包含异常的方法
     * @return
     */
//    @ExceptionHandler({ArithmeticException.class,IllegalStateException.class})
//    public ModelAndView handlerArithmeticException(Exception e){    //只能包含异常
//        ModelAndView view = new ModelAndView("error");
//        System.out.println(e);
//        view.addObject("error",e);
//        return view;
//    }
}
