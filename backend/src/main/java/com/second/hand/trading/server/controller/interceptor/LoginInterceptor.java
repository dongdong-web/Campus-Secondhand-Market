package com.second.hand.trading.server.controller.interceptor;

import com.second.hand.trading.server.model.UserModel;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录验证拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserModel xxUser = (UserModel) session.getAttribute("user");
        if (xxUser == null){
            //ajax请求返回401
            if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))){
                response.sendError(401);
            }
            return true;
        }
        //登录可以继续操作
        return true;
    }
}
