package com.nvc.bookshop.interceptor;

import com.nvc.bookshop.pojo.User;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if(user !=null && !StringUtils.isEmpty(user.getUsername())){
            return true;
        }else{
            response.sendRedirect("/home/index");
            return false;
        }
    }
}
