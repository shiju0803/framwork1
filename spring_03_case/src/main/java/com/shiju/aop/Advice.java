package com.shiju.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author shiju
 * @date 2021/06/04 18:12
 */
@Component
@Aspect//声明该类为切面类
@EnableAspectJAutoProxy
public class Advice {
    //定义切入点表达式的方法,方法体不需要写任何内容，方法名就是切入点的id
    @Pointcut("execution(* com.shiju..StudentService.*(..))")
    public void pt() {
    }

    Object value = null;

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) {
        try {
            //前置通知
            long start = System.currentTimeMillis();
            //执行操作，调用目标对象的方法
            value = pjp.proceed();
            //后置通知：获取结束时间
            long end = System.currentTimeMillis();
            //获取正在运行的方法名
            String name = pjp.getSignature().getName();
            //计算差值，打印结果
            System.out.println("执行" + name + "方法耗时：" + (end - start) + "毫秒");

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return value;
    }
}
