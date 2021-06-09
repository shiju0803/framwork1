package com.shiju.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.shiju.domain.Student;
import com.shiju.service.StudentService;
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

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //初始化spring的核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取Service
        studentService = ac.getBean("studentService", StudentService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        //根据实际情况，调用selectByPage方法或者save方法或者update方法或者delete
        String method = request.getParameter("method");
        if("selectByPage".equals(method)){
            //分页查询
            selectByPage(request,response);
        }else if("addStudent".equals(method)){
            //添加学生
            addStudent(request,response);
        }else if("updateStudent".equals(method)){
            //修改学生
            updateStudent(request,response);
        }else if("deleteStudent".equals(method)){
            //删除学生
            deleteStudent(request,response);
        }
    }
    /**
     * 处理分页查询的请求
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取请求参数，currentPage、pageSize
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        //2 调用service层方法获取结果PageInfo对象
        PageInfo<Student> info = studentService.selectByPage(Integer.parseInt(currentPage), Integer.parseInt(pageSize));

        //3 转换成json响应给客户端
        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getWriter(),info);
    }

    /**
      * 处理添加学生的请求
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取请求参数并封装
        Student student=new Student();
        try {
            BeanUtils.populate(student,request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //2 调用service层方法，添加学生信息
        int count=studentService.addStudent(student);
        //3 响应结果
        //response.getWriter().write(count); //错  write方法底层会将int类型强转成char类型，到时候响应的就不是1了
        //response.getWriter().print(count);  //ok
        response.getWriter().write(count+"");  //ok
    }

    /**
     * 处理修改学生的请求
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取请求参数
        Student student=new Student();
        try {
            BeanUtils.populate(student,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //2 调用service层方法，修改学生信息
        int count = studentService.updateStudent(student);
        //3 响应结果
        response.getWriter().write(count+"");  //ok
    }

    /**
     * 处理删除学生的请求
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取请求参数
        String number = request.getParameter("number");
        //2 调用service层方法，删除学生信息
        int count = studentService.deleteStudent(number);
        //3 响应结果
        response.getWriter().write(count+"");  //ok
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
