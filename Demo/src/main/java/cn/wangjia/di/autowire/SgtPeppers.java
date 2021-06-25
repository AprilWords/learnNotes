package cn.wangjia.di.autowire;

import org.springframework.stereotype.Component;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/4
 */
//@Component
public class SgtPeppers implements CompactDisc {
    private String  title =  "漫步人生路";
    private String  artist =  "邓丽君" ;
    public void playTrack(int i) {
       System.out.println("play the"+title +"by" +artist);

    }
}
