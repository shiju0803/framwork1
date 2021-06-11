package com.shiju.controller;

import com.github.pagehelper.PageInfo;
import com.shiju.domain.Code;
import com.shiju.domain.Result;
import com.shiju.domain.User;
import com.shiju.exception.BusinessException;
import com.shiju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shiju
 * @date 2021/06/10 15:06
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    /**
     * Rest行为约定方式
     * 	 - GET（查询） http://localhost/user/1 GET
     *   - POST（保存） http://localhost/user POST
     *   - PUT（更新） http://localhost/user PUT
     *   - DELETE（删除） http://localhost/user/1  DELETE
     */

    /**
     * 查询所有用户信息
     * 访问路径：http://localhost/user+GET请求
     */
    @GetMapping
    public Result findAll() {
        List<User> list = service.findAll();
        return list != null ? new Result(Code.QUERY_OK, "查询成功", list) : new Result(Code.QUERY_FAIL, "查询失败");
    }

    /**
     * 分页查询用户信息
     *
     * @param currentPage 当前页
     * @param pageSize    每页条数
     * @return 分页数据
     * 访问路径：http://localhost/user/1/5+GET请求
     */
    @GetMapping("{currentPage}/{pageSize}")
    public Result findByPage(@PathVariable int currentPage,
                             @PathVariable int pageSize) {
        if (currentPage < 1) {
            throw new BusinessException("当前页数必须大于0");
        }
        PageInfo<User> info = service.findByPage(currentPage, pageSize);
        int size = info.getList().size();
        return size != 0 ? new Result(Code.QUERY_OK, "查询成功", info) : new Result(Code.QUERY_FAIL, "查询失败");
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return 用户信息
     * 访问路径：http://localhost/user/1+GET请求
     */
    @GetMapping("{id}")
    public Result findById(@PathVariable Integer id) {
        User user = service.findById(id);
        return user != null ? new Result(Code.QUERY_OK, "查询成功", user) : new Result(Code.QUERY_FAIL, "查询失败");
    }

    /**
     * 保存用户信息
     *
     * @param user 要保存用户对象
     * @return 影响的行数访问
     * 路径：http://localhost/user+POST请求
     */
    @PostMapping
    public Result save(@RequestBody @Validated User user, Errors errors) {
        //执行操作前校验用户信息
        checkUser(errors);
        //执行添加操作
        int count = service.save(user);
        return count > 0 ? new Result(Code.SAVE_OK, "添加成功") : new Result(Code.SAVE_FAIL, "添加失败");
    }

    /**
     * 修改用户信息
     *
     * @param user 要修改的用户对象
     * @return 影响的行数
     * 路径：http://localhost/user+PUT请求
     */
    @PutMapping
    public Result update(@RequestBody @Validated User user, Errors errors) {
        //执行操作前校验用户信息
        checkUser(errors);
        //执行修改操作
        int count = service.update(user);
        return count > 0 ? new Result(Code.UPDATE_OK, "修改成功") : new Result(Code.UPDATE_FAIL, "修改失败");
    }

    /**
     * 根据id删除用户信息
     *
     * @param id 要删除的用户id
     * @return 影响的行数
     * 路径：http://localhost/user/1+DELETE请求
     */
    @DeleteMapping("{id}")
    public Result delete(@PathVariable @Validated Integer id) {
        if (id < 1) {
            throw new BusinessException("非法的id值");
        }
        int count = service.delete(id);
        return count > 0 ? new Result(Code.DELETE_OK, "删除成功") : new Result(Code.DELETE_FAIL, "删除失败");
    }

    /**
     * 用户登录
     *
     * @param user
     * @param session
     * @return 查询到的用户对象
     * <p>
     * 路径：http://localhost/user/黄桂田/123456+POST请求
     */
    @RequestMapping("login")
    public Result login(@RequestBody User user,
                        HttpSession session) {
        User u = service.login(user.getUsername(), user.getPassword());
        //判断用户是否登录成功
        if (u != null) {
            System.out.println(user);
            session.setAttribute("user", user);
        }
        return user != null ? new Result(Code.LOGIN_OK, "登录成功", user) : new Result(Code.LOGIN_FAIL, "登陆失败");
    }

    @RequestMapping("checkLogin")
    public Result checkLogin() {
        return new Result(Code.LOGIN_OUT, "请先进行登录");
    }


    /**
     * 校验用户信息
     *
     * @param errors 保存了用户的错误信息
     */
    private void checkUser(Errors errors) {
        if (errors.hasErrors()) {
            List<FieldError> fieldErrors = errors.getFieldErrors();
            for (FieldError error : fieldErrors) {
                //获取字段名
                System.out.println(error.getField());
                //获取错误信息
                System.out.println(error.getDefaultMessage());
                //如果是异步请求我们可以将异常信息保存到map集合中，转换成json响应给客户端
                //在异常处理通知类中将异常信息转换成json响应给客户端
                throw new BusinessException(error.getDefaultMessage());
            }
        }
    }
}
