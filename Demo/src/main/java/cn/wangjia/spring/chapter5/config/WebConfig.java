package cn.wangjia.spring.chapter5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/22
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = {"cn.wangjia.spring.chapter5.web" })
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 1.没有配置视图解析器 默认使用BeanNameView-Resolver
     *2.没有启用组件扫描，只能找到显式声明在配置类中的控制器
     *3.DispatcherServlet会映射为应用的默认Servlet，处理所有的请求，包括静态资源的请求，如图表和样式表
     *
     */
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/*");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return  resolver;

    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }



}
