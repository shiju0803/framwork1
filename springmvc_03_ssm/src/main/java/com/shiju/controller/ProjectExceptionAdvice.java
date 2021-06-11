package com.shiju.controller;

import com.shiju.domain.Code;
import com.shiju.domain.Result;
import com.shiju.exception.BusinessException;
import com.shiju.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author shiju
 * @date 2021/06/10 19:53
 * <p>
 * 自定义异常处理类
 */
@RestControllerAdvice //等价于 @ControllerAdvice + @ResponseBody
public class ProjectExceptionAdvice {

    /**
     * 处理业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e) {
        //为了方便我们自己看，需要将异常信息打印到控制台
        e.printStackTrace();
        //需要告诉用户是因为自己的不合法输入造成的，需要把异常信息告知用户
        return new Result(Code.BUSINESS_EXCEPTION, e.getMessage());
    }

    /**
     * 处理系统异常
     */
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e) {
        //给用户一个友好的提示信息，将异常记录到数据库/文件中,通知运维和开发人员。
        e.printStackTrace();
        return new Result(Code.SYSTEM_EXCEPTION, "服务器连接超时，请稍后再试");
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler(Exception.class)
    public Result doException(Exception e) {
        e.printStackTrace();
        //给用户一个友好的提示信息，将异常记录到数据库/文件中,通知开发人员。
        return new Result(Code.OTHER_EXCEPTION, "程序员小哥哥正在紧急修复中");
    }
}
