package com.shiju.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 通知类，告诉spring在增强的前后需要做什么事
 *
 * @author shiju
 * @date 2021/06/04 09:29
 */
@Component
@Aspect//代替：<aop:aspect ref="advice">，该类即是一个通知类也是一个切面类
public class Advice {

    // @Before("execution(* com.shiju.service.impl.StudentServiceImpl.*(..))")
    public void before() {
        //前置通知：开启事务
        System.out.println("前置通知：开启事务");
    }

    // @AfterReturning("execution(* com.shiju.service.impl.StudentServiceImpl.*(..))")
    public void afterReturn() {
        //后置通知：提交事务
        System.out.println("后置通知：提交事务");
    }

    // @AfterThrowing("execution(* com.shiju.service.impl.StudentServiceImpl.*(..))")
    public void afterThrowable() {
        //异常通知：回滚事务
        System.out.println("异常通知：回滚事务");
    }

    // @After("execution(* com.shiju.service.impl.StudentServiceImpl.*(..))")
    public void after() {
        //最终通知：释放资源
        System.out.println("最终通知：释放资源");
    }

    //环绕通知

    /**
     * ProceedingJoinPoint:正在执行的连接点，也就是拦截到的目标方法
     */
    @Around("execution(* com.shiju.service.impl.StudentServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) {
        Object value = null;
        try {
            //前置增强
            // before();
            //执行目标方法对象
            //获取目标方法的参数
            Object[] args = pjp.getArgs();
            System.out.println("目标方法的参数 = " + Arrays.toString(args));
            value = pjp.proceed(args);
            afterReturn();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            afterThrowable();
        } finally {
            //后置增强
            after();
        }
        return value;
    }
}
