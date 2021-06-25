package cn.wangjia.spring.chapter3.aop.pointcut;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/16
 */
@Component
public class Movie implements Performance {
    @Qualifier
    public void perform() {
        System.out.print("take movie \r\n");
    }
}
