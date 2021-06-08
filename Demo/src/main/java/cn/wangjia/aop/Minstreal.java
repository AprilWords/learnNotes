package cn.wangjia.aop;

import java.io.PrintStream;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/3
 */
public class Minstreal {

    private PrintStream printStream;
    public Minstreal(PrintStream printStream ){
        this.printStream = printStream;
    }
    //探险前
    public void singBeforeQuest(){
        printStream.println("fa la la,the knight is so brave!");

    }
    public void singAgterQuest(){
        printStream.println("tee hee hee,the knight is did embark on a quest");

    }


}
