package com.shiju.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shiju
 * @date 2021/06/08 11:57
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //2.获取会话域对象中数据
        Object user = request.getSession().getAttribute("user");

        //3.判断用户名
        if (user == null) {
            System.out.println("自定义拦截器执行了！！");
            //重定向到登录页面
            response.sendRedirect(request.getContextPath() + "/login.html");
            return false;
        }
        return true;
    }
}
