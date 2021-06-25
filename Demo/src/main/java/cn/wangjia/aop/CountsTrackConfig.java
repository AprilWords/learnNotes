package cn.wangjia.aop;

import cn.wangjia.di.autowire.BlankDisc;
import cn.wangjia.di.autowire.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/16
 */
//@Configuration
@EnableAspectJAutoProxy
public class CountsTrackConfig {

    @Bean
    public TrackCounter trackCounter(){
        return new TrackCounter();
    }
    @Bean
    public CompactDisc first(){
        String artist = "王小嘉";
        String title = "王小嘉";
        List<String> listTracks = new ArrayList<String>();
        listTracks.add("11111111111");
        listTracks.add("22222222222");
        listTracks.add("33333333333");
        BlankDisc bd = new BlankDisc(title,artist,listTracks);
        return bd;


    }


}
