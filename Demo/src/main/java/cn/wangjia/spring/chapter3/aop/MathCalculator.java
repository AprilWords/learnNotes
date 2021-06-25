package cn.wangjia.spring.chapter3.aop;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/11
 */
public class MathCalculator {

    public int div(int i, int j) {
        System.out.println("MathCalculator >> div");
        return i / j;
    }

}
