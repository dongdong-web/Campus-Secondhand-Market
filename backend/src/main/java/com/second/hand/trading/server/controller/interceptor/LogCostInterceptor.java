package com.second.hand.trading.server.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogCostInterceptor implements HandlerInterceptor {
    private long start = System.currentTimeMillis();
    private static final Logger logger = LogManager.getLogger(LogCostInterceptor.class);


        // 只要preHandle方法返回true，必执行afterCompletion
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        start = System.currentTimeMillis();

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("请求：{}?{}，耗时：{}ms",
                httpServletRequest.getRequestURI(),
                httpServletRequest.getQueryString(),
                (System.currentTimeMillis() - start)
        );
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}