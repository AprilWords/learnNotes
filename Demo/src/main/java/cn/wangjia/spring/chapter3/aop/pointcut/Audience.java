package cn.wangjia.spring.chapter3.aop.pointcut;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/16
 */
@Aspect
public class Audience {
    /**
     * 1.切面 = 通知 + 切点
     * 2.通知:  是什么 +何时用（前置 后置 返回 异常 环绕）
     * 3.切点: 哪一处连接点应用通知
     * 4. @Pointcut定义可重复的切点
     */
    @Pointcut("execution(public void cn.wangjia.spring.chapter3.aop.pointcut.Movie.perform(..))")
    public void performance() {}

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp){
        try{

            System.out.print("silencing cell phone \r\n");
            System.out.print("taking seats \r\n");
            //jp.proceed();
            System.out.print("ClaP! Clap! Clap!\r\n");

        }catch (Throwable e){
            System.out.print("Demanding a refund");
        }
    }
    /*@Before("performance()")
    public void silenceCeilPhones(){
        System.out.println("Silence cell phones");

    }
    @Before("performance()")
    public void takeSeats(){
        System.out.println("take seat");

    }
    @AfterReturning("performance()")
    public void applause(){
        System.out.println("Clap Clap Clap");

    }
    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demanding a refund");

    }*/
   /* @Before("execution(public * cn.wangjia.spring.chapter3.aop.pointcut.Performance.perform(..))")
    public void silenceCeilPhones(){
        System.out.println("Silence cell phones");

    }
    @Before("execution(public * cn.wangjia.spring.chapter3.aop.pointcut.Performance.perform(..))")
    public void takseSeats(){
        System.out.println("take seat");

    }
    @AfterReturning("execution(public * cn.wangjia.spring.chapter3.aop.pointcut.Performance.perform(..))")
    public void applause(){
        System.out.println("Clap Clap Clap");

    }
    @AfterThrowing("execution(public * cn.wangjia.spring.chapter3.aop.pointcut.Performance.perform(..))")
    public void demandRefund(){
        System.out.println("Demanding a refund");

    }*/
}
