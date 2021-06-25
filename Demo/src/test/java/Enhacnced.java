import cn.wangjia.aop.CountsTrackConfig;
import cn.wangjia.spring.chapter3.aop.pointcut.Encoreable;
import cn.wangjia.spring.chapter3.aop.pointcut.PerformacneConfig;
import cn.wangjia.spring.chapter3.aop.pointcut.Performance;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PerformacneConfig.class)
public class Enhacnced {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    @Autowired
    private Performance movie;
    @Test
    public void test11(){

        movie.perform();
        assertEquals("take movie \r\n",log.getLog());
        Encoreable temp = (Encoreable) movie;
        temp.performEncore();
        assertEquals("fwfw",log.getLog());



    }
}
