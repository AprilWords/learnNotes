import cn.wangjia.aop.CountsTrackConfig;
import cn.wangjia.di.MediaPlayer;
import cn.wangjia.di.config.CDplayerConfig;

import cn.wangjia.spring.chapter3.aop.pointcut.PerformacneConfig;
import cn.wangjia.spring.chapter3.aop.pointcut.Performance;
import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/16
 */

//@ContextConfiguration(classes = PerformacneConfig.class)
public class AopTest {

    @Test
    public void test02(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(PerformacneConfig.class);

        Performance sss = annotationConfigApplicationContext.getBean(Performance.class);
        sss.perform();
        System.out.print("dfefe");
    }
    @Test
    public void test03(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(CDplayerConfig.class);
        MediaPlayer c = annotationConfigApplicationContext.getBean(MediaPlayer.class);
        c.play();
    }
    @Test
    public void test04(){
        AnnotationConfigApplicationContext ap = new AnnotationConfigApplicationContext(CountsTrackConfig.class);
       MediaPlayer m =  ap.getBean("cDplayer",MediaPlayer.class);
       m.play();
    }

}
