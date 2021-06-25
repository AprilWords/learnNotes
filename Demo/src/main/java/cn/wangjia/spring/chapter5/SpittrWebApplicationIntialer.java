package cn.wangjia.spring.chapter5;

import cn.wangjia.spring.chapter5.config.RootConfig;
import cn.wangjia.spring.chapter5.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/22
 */
public class SpittrWebApplicationIntialer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class []{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
