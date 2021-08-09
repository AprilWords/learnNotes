package cn.wangjia.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/8/5
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while(true){
            list.add(new OOMObject());
        }


    }



}
