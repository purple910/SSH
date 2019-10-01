package com.company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @program: springMVC-02 com.company.exception.MyArrayIndexOutofBoundsException
 * @description: 异常界面
 * @author: fate
 * @create: 2019-10-01 14:40
 **/
@ResponseStatus(value = HttpStatus.FORBIDDEN , reason = "数组越界")
public class MyArrayIndexOutofBoundsException extends Exception {


}
