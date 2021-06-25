package cn.wangjia.di.config;

import cn.wangjia.di.autowire.BlankDisc;
import cn.wangjia.di.autowire.CDplayer;
import cn.wangjia.di.autowire.CompactDisc;
import cn.wangjia.di.autowire.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/4
 */
@Configuration
//@ComponentScan(basePackages = {"cn.wangjia"})
public class CDplayerConfig {

    /*@Bean//该注解会告诉spring，这个方法会返回一个对象，该对象要注册为spring应用上下文中的bean，方法体包含了最终产生bean实例的逻辑
    public CompactDisc sgtPeppers(){//bean的名字一般和方法名一样，或者可以用name注解重命名

        //可根据一个随机数 创建不同的bean
        return new SgtPeppers();
    }
    @Bean
    public CDplayer cDplayer(){
        //看起来 CompacDisc是通过sgtPeppers得到的，但情况并不是，spring会拦截所有对它的调用，并确保直接返回该方法所创建的bean
        return new CDplayer(sgtPeppers());
    }*/
    @Bean
    public CDplayer cDplayer(CompactDisc blankDisc){
        //看起来 CompacDisc是通过sgtPeppers得到的，但情况并不是，spring会拦截所有对它的调用，并确保直接返回该方法所创建的bean
        CDplayer cDplayer = new CDplayer(blankDisc);
        cDplayer.setCd(blankDisc);//
        return cDplayer;
    }
    @Bean
    public CompactDisc blankDisc(){
        List<String> listTracks = new ArrayList<String>();
        listTracks.add("11111111111");
        listTracks.add("22222222222");
        listTracks.add("33333333333");
        return new BlankDisc("wangjia","wangjia",listTracks);
    }


}
