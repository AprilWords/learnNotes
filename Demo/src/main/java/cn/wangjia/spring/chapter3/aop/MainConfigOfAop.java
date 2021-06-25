package cn.wangjia.spring.chapter3.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/11
 */
@EnableAspectJAutoProxy
//@Configuration
public class MainConfigOfAop {

    //业务逻辑类加入到容器中
   /* @Bean
    public MathCalculator mathCalculator(){

        System.out.println("mathCalculator bean");
        return new MathCalculator();

    }*/
    //切面类加入到容器中
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }





}
