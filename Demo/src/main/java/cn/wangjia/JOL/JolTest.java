package cn.wangjia.JOL;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/7/14
 */
public class JolTest {

    public static void main(String[] args) {

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        System.out.print("*************************************");
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }




    }


}
