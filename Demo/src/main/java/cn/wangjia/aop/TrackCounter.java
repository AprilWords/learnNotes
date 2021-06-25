package cn.wangjia.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/16
 */
@Aspect
public class TrackCounter {

    private Map<Integer,Integer> trackCounts = new HashMap<Integer, Integer>();
    @Pointcut("execution(* cn.wangjia.di.autowire.CompactDisc.playTrack(int)) && args(trackNumber)")
    public void trackPlayed(int trackNumber){}

    @Before("trackPlayed(trackNumber)")
    public void countTrack (int trackNumber){
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber,currentCount+1);
    }
    public int getPlayCount(int trackNumber){
        return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber):0;
    }

}
