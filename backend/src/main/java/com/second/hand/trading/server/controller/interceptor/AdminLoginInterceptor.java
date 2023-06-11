//package com.second.hand.trading.server.controller.interceptor;
//import com.second.hand.trading.server.model.AdminModel;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//public class AdminLoginInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        //获取管理员信息
//        AdminModel admin = (AdminModel) session.getAttribute("admin");
//        //管理员未登录
//        if (admin == null){
//            response.sendRedirect("http://localhost:8081/#/login-admin");
//            System.out.println("管理员未登录");
//            return true;
//        }
//        //管理员已登录
//        else {
//            response.sendRedirect("http://localhost:8081/#/platform-admin");
//            System.out.println("管理员已登录");
//            return false;
//        }
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
//}
