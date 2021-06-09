package com.shiju.controller;
import com.shiju.domain.User;
import com.shiju.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //初始化spring的核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取Service
        userService = ac.getBean("userService",UserService.class);
    }

    /**
     * 处理登录的请求
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取请求参数 username和password，并封装成user对象
        User user=new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //2 调用service层的login方法，得到新的user对象
        User existUser=userService.login(user);

        //3 判断如果user!=null,说明登录成功，将user保存到session
        if(existUser!=null){
            request.getSession().setAttribute("user",existUser);
            //登录成功
            response.getWriter().write("true");
        }else{
            //登录失败
            response.getWriter().write("false");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
