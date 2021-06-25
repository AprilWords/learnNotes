package cn.wangjia.spring.chapter3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/11
 */
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //1.本类引用   可选项       modifiers-pattern?                   declaring-type-pattern?                            Throws-pattern?
    //2.其他的切面引用execution(modifier-pattern?  ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)throws-pattern?)
    //modifiers-pattern?  修饰符匹配 public匹配公共方法
    //declaring-type-pattern? 类路径匹配
    //name-pattern()方法名匹配  * 代表所有,set*,代表以set开头的所有方法
    //param-pattern(..)代表所有参数,
    //()代表一个参数,
    //(,String)代表第一个参数为任何值,第二个为String类型.
    @Pointcut("execution(public int cn.wangjia.spring.chapter3.aop.MathCalculator.*(..))")
    private void pointCut(){}

    //@Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
    //JoinPoint一定要出现在参数列表的第一位
    @Before(value = "pointCut()")
    public void LogStart(JoinPoint joinPoint){

        System.out.println("logStart>>>>"+joinPoint.getSignature().getName()+">>>>"+ Arrays.toString(joinPoint.getArgs()));
    }
    @After(value ="pointCut()")
    public void logEnd(JoinPoint joinpoint) {
        System.out.println("logEnd>>>>>"+joinpoint.getSignature().getName()+">>>>"+Arrays.toString(joinpoint.getArgs()));
    }

}
