import cn.wangjia.aop.CountsTrackConfig;
import cn.wangjia.aop.TrackCounter;
import cn.wangjia.di.autowire.CompactDisc;
import cn.wangjia.di.config.CDplayerConfig;
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
 * @date 2021/6/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CountsTrackConfig.class)
public class AopParam {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Autowired
    private CompactDisc cd;
    @Autowired
    TrackCounter trackCounter;

    @Test
    public void test01(){
        cd .playTrack(1);
        cd .playTrack(1);
        cd .playTrack(2);
        cd .playTrack(2);
        cd .playTrack(0);
        cd .playTrack(2);
        cd .playTrack(2);
        cd .playTrack(1);
        cd .playTrack(1);

        assertEquals(4,trackCounter.getPlayCount(1));
        assertEquals(1,trackCounter.getPlayCount(0));
        assertEquals(4,trackCounter.getPlayCount(2));



    }



}
