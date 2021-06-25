package cn.wangjia.spring.chapter3.aop.pointcut;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/16
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "cn.wangjia"})
public class PerformacneConfig {
    @Bean
    public Audience audience(){
        return new Audience();
    }
    @Bean
    public Movie movie(){
        return new Movie();
    }
}
