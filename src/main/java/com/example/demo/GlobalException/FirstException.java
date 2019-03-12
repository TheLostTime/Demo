package com.example.demo.GlobalException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class FirstException extends RuntimeException  {

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public String defineExceptionHandle(){
        return "我定义的异常";
    }
}
