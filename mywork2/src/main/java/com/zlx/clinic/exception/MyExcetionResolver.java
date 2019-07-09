package com.zlx.clinic.exception;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExcetionResolver  extends HandlerExceptionResolverComposite {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        MyException m1=null;
        if(ex instanceof MyException){
            m1= (MyException) ex;
        }else {
            m1= new MyException("未知错误");
        }
        String message=m1.getMessage();
        ModelAndView m  =new ModelAndView();
        m.addObject("errorMessage",m1);
        m.setViewName("error");
        return m;
    }
}
