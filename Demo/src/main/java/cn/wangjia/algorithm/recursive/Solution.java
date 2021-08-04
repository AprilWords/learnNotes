package cn.wangjia.algorithm.recursive;

import java.util.Date;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/7/26
 */
public class Solution {
    class Node{
        int date;
        Node next;
    }
    static int result = 0;


    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println("fn阶乘:"+solution.factorial(10));
        //System.out.println("斐波那契:"+solution.feibonaqie(10));
        System.out.println(new Date().toString());
        System.out.println("青蛙:"+solution.jump(20));
        System.out.println(new Date().toString());
        System.out.println(result);

    }

    //求n的阶乘
    /**
     *  1.函数功能为求n的阶乘
     *  2.递归结束条件n<=2 返回n本身
     *  3.找寻函数的等价关系式 f(n) = n*f(n-1)
     */
    public int factorial(int n){

        if(n <= 2){
            return n;
        }else{
            return n*factorial(n-1);
        }
    }
    /**
     * 定义: f(1) = 1,f(2) =1,f(n) = f(n-1)+f(n-2)
     *
     *  1.函数功能:计算斐波那契额
     *  2.边界条件: n <=2  return n
     *  3.等价关系式 f(n) = f(n-1)+f(n-2)
     */
    public int feibonaqie(int n){
        if(n <= 2) {
            return 1;
        } else{

            return feibonaqie(n-1)+feibonaqie(n-2);
        }

    }
    /**
     * 定义: 小青蛙跳台阶: 一次可以跳1级也可以跳2级，跳上一个n级的台阶有多少中跳法
     *
     *  1.函数功能:统计多少种跳法
     *  2.边界条件: n = 1  n = 2 2种  n=3(1+1+1) n=4()
     *  3.等价关系式 f(n) = f(n-2)+f(n-1)
     */
    public int jump(int n){

        result++;
        if(n<= 3){
            return n;
        }else{

            return jump(n-1)+jump(n-2);
        }


    }
    /**
     * 定义:。例如链表为：1->2->3->4。反转后为 4->3->2->1
     * 1.功能：反转单链表
     * 2.边界条件: 一个节点或者空节点直接返回
     * 3.等价关系:
     */
    Node reverseList(Node head){
        if(head == null || head.next == null){
            return head;
        }else{
            Node newListHead = reverseList(head.next);
             head.next.next = head;
            newListHead.next = null;
            return newListHead;
        }




    }



}
