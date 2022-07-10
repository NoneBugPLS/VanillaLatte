package com.zelin.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 类名：通知对象(使用注解完成AOP)
 * 作者：Lun
 * 功能：
 * 时间：2021/11/14 17:31
 */
@Aspect
@Component
public class MyAdvice2 {
    /**
     * 前置通知(Before)：是调用方法之前调用
     * 后置通知(AfterReturning)：在调用方法之后调用（出现异常不调用 ）
     * 环绕通知(Around):在调用方法的前后，都会执行
     * 异常通知(After-Throwing):在方法调用出现异常时执行
     * 后置通知(After):无论是否出现异常都会调用
     */
    //1. 定义切入点表达式
    @Pointcut("execution(* com.zelin.dao.impl.*DaoImpl2.*(..))")
    private void pt(){

    }
    @Before("MyAdvice2.pt()")
    public void before(){
        System.out.println("前置通知.");
    }

    @AfterReturning("MyAdvice2.pt()")
    public void afterReturning(){
        System.out.println("后置通知，出现异常不调用.");
    }

    @Around("MyAdvice2.pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("环绕通知-前面代码");
        Object proceed = pjp.proceed();
        System.out.println("环绕通知-后面代码");
        return proceed;
    }
    @AfterThrowing("MyAdvice2.pt()")
    public void afterThrowing(){
        System.out.println("不得了了，出了异常了！【后置通知】");
    }


    @After("MyAdvice2.pt()")
    public void after(){
        System.out.println("无论是否出现异常，都会调用！【后置通知】");
    }
}
