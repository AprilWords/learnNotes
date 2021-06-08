package cn.wangjia.di.autowire;

import java.util.List;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/8
 */
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;
    public BlankDisc(String title,String artist,List<String> tracks){

        this.title = title;
        this.artist = artist;
        this.tracks = tracks;


    }
    public void play() {
      System.out.println("playing" +title+"by"+artist);
      for(String track: tracks){
          System.out.println("-Track:"+track);
      }
    }
}
