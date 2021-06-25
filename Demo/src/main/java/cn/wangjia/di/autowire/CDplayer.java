package cn.wangjia.di.autowire;

import cn.wangjia.di.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/4
 */
@Component
public class CDplayer implements MediaPlayer {

    private CompactDisc cd;
    @Autowired
    public CDplayer(CompactDisc cd){
        this.cd = cd;
    }

    public CompactDisc getCd() {
        return cd;
    }

    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.playTrack(1);
    }
}
