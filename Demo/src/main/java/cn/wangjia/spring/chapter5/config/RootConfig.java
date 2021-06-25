package cn.wangjia.spring.chapter5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/22
 */
@Configuration
@ComponentScan(basePackages = "cn.wangjia.spring.chapter5.spitter",excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
public class RootConfig {



}
