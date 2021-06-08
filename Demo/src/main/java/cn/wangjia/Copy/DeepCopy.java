package cn.wangjia.Copy;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/5/18
 */
public class DeepCopy {

    private   int name;
    protected int age;
              int date;
     public   int data;

    static class Body implements Cloneable{
        public Head head;

       // public Body() {}

        public Body(Head head) {this.head = head;}

        @Override
        protected Body clone() throws CloneNotSupportedException {
            Body d =  (Body)super.clone();
            //d.head =
            d.head = (Head) this.head.clone();
            return d;
        }

    }
    static class Head implements Cloneable {
        private  int sfs;

        public Head() {}

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    public static void main(String[] args) throws CloneNotSupportedException {

        Body body = new Body(new Head());

        Body body1 =  body.clone();

        System.out.println("body == body1 : " + (body == body1));

        System.out.println("body.head == body1.head : " + (body.head == body1.head));
    }
}
