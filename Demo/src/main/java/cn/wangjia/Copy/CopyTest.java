package cn.wangjia.Copy;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/5/18
 */
public class CopyTest implements Cloneable {
    private  int age;
    private String name;
    public CopyTest(int age,String name)  {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CopyTest p1 = new CopyTest(14,"wnagjia");
        CopyTest p2 = (CopyTest) p1.clone();
        String result = p1.name == p2.name ? "浅拷贝":"深拷贝";
        System.out.println(result);
        DeepCopy copy = new DeepCopy();



    }



}
