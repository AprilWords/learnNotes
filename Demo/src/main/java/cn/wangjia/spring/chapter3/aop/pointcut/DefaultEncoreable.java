package cn.wangjia.spring.chapter3.aop.pointcut;

import org.springframework.stereotype.Component;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/17
 */
@Component
public class DefaultEncoreable implements Encoreable {
    public void performEncore() {
        System.out.print("fwfw");
    }
}
