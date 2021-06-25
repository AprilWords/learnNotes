package cn.wangjia.spring.chapter3.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/17
 */
@Aspect
@Component
public class EncoreableIntroducer {

   @DeclareParents(value = "cn.wangjia.spring.chapter3.aop.pointcut.Performance+",defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
