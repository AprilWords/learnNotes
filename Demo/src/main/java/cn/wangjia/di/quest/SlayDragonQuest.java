package cn.wangjia.di.quest;

import cn.wangjia.di.Quest;

import java.io.PrintStream;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/2
 */
public class SlayDragonQuest implements Quest {
    private PrintStream printStream;
    public SlayDragonQuest(PrintStream printStream){
        this.printStream = printStream;
    }
    public void embark() {
        printStream.println("embark on quest to slay the dragon");

    }
}
