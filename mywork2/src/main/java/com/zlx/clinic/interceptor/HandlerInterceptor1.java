package com.zlx.clinic.interceptor;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class HandlerInterceptor1 implements HandlerInterceptor {
    //可不登录进入的url
    private List<String> excludedUrls;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI=request.getRequestURI();
       for(String url:excludedUrls){
           if(requestURI.contains(url)){
               System.out.println("=============="+"无需登录");
               return true;
           }
       }

        HttpSession session = request.getSession();
        List<Object> l1=new ArrayList<>();
        l1.add( session.getAttribute("patient"));
        l1.add( l1.add( session.getAttribute("patient")));
        for(Object o:l1){
            if(o!=null){
                System.out.println("==============="+"用户登陆");
                return true;
            }
        }


        System.out.println("=============="+"用户未登录");
        response.sendRedirect("/userlogin.jsp");
        return false;

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }
}
