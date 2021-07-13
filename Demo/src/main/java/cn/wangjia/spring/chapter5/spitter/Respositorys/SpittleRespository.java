package cn.wangjia.spring.chapter5.spitter.Respositorys;

import java.util.List;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/24
 */
public interface SpittleRespository  {

    List<Spittle> findSpittles(long max,int count);
    Spittle findOne(long spittleID);



}
