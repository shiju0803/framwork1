package com.shiju.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shiju
 * @date 2021/06/10 21:45
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * @param request  请求对象
     * @param response 响应对象
     * @param handler  封装处理器(Controller)中的方法对象
     * @return 是否拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取会话域对象中数据
        Object user = request.getSession().getAttribute("user");
        //System.out.println(user);
        //判断用户名
        if (user == null) {
            System.out.println("自定义拦截器拦截了你的操作");
            response.sendRedirect(request.getContextPath() + "/user/checkLogin");
            return false;
        }
        return true;
    }
}
