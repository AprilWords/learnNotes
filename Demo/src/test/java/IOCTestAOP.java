import cn.wangjia.spring.chapter3.aop.MainConfigOfAop;
import cn.wangjia.spring.chapter3.aop.MathCalculator;
import cn.wangjia.spring.chapter3.aop.pointcut.PerformacneConfig;
import cn.wangjia.spring.chapter3.aop.pointcut.Performance;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PerformacneConfig.class)
public class IOCTestAOP {
    @Autowired
    private Performance movie;
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);

        MathCalculator mathCalculator = new MathCalculator(); //applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(10, 2);
        applicationContext.close();
    }
    @Test
    public void test02() {
       // AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PerformacneConfig.class);

        movie.perform();
       // applicationContext.close();
    }
}
