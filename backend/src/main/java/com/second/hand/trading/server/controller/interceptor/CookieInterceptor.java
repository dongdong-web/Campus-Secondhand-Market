package com.second.hand.trading.server.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        // 获取所有的cookie并进行处理
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                System.out.println("Cookie Name: " + cookie.getName());
//                System.out.println("Cookie Value: " + cookie.getValue());
//            }
//        }
//
//        // 返回 true 表示继续执行后续的拦截器链或处理程序，返回 false 表示中断请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        // 后处理方法，在处理程序执行之后调用
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 完成处理方法，在请求完成之后调用
    }
}
