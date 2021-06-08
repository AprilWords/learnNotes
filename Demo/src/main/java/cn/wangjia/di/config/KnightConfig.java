package cn.wangjia.di.config;

import cn.wangjia.di.BraveKnight;
import cn.wangjia.di.Knight;
import cn.wangjia.di.Quest;
import cn.wangjia.di.quest.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/2
 */
@Configuration
public class KnightConfig {
    @Bean
    public Knight knight(){
        return new BraveKnight(quest());
    }
    @Bean
    public Quest quest(){
        return new SlayDragonQuest(System.out);

    }
}
