import cn.wangjia.di.MediaPlayer;
import cn.wangjia.di.autowire.CompactDisc;
import cn.wangjia.di.config.CDplayerConfig;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import sun.rmi.runtime.Log;

import javax.print.attribute.standard.Media;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDplayerConfig.class)
public class CDplayerTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    @Autowired
    private CompactDisc cd;
    @Autowired
    private MediaPlayer player;
    @Test
    public void cdshouldbePlay(){
        assertNotNull(cd);
        assertNotNull(player);

    }
    @Test
    public void playerhouldbePlay(){

        player.play();
        String s = "play the漫步人生路by邓丽君";
        String w = log.getLog();
        boolean b= s.equals(w);
        assertEquals("play the漫步人生路by邓丽君\r\n",log.getLog());

    }


}
