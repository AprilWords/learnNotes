package cn.wangjia.algorithm.dp;

import java.util.Date;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/8/2
 */
public class SolutionDP {

    /* 数学归纳法:
     * step1: dp[i]  定义数组元素的含义
     * step2: 找出数组元素之间的关系式 dp[n]  可以通过dp[n-1]....dp[0]求出
     * step3: 找出初始值
     */

    public static void main(String[] args) {
        int[] nums = {-2,5,-3,4,-1,2,1,-5,4};
        System.out.println(new Date().toString());
       // max(3,2,1);
        //max(10,7,9);
        System.out.println(maxSubArray(nums));
        System.out.println(new Date().toString());
    }
    public static int jump (int n){

        if(n<=2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i =3;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    /*
     *当机器人走到i,j这个位置一共有dp[i][j]种方法
     * 两种: 走下: dp[i][j] = dp[i][j-1]
     *      走右: dp[i][j] = dp[i-1][j]  =>  dp[i][j] =dp[i][j-1]+dp[i-1][j];
     * 边界: dp[i][j] i=j =0 i<=7 j<=3  i=0时 dp[0][j]   j=0时 dp[i][0] 只有跳过
     */
    public static int move(int m,int n){

        if(m< 0 || n<0){
            return 0;
        }
        int[][] dp = new int[m+1][n+1];


            for(int i= 0;i<n+1;i++)
                dp[0][i] =1;
            for(int i= 0;i<m+1;i++)
                dp[i][0] = 1;

            for(int i=1;i<m+1;i++){
                for(int j=1;j<n+1;j++)
                 dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
            return dp[m][n];
    }

    /**
     *[-2,1,-3,4,-1,2,1,-5,4]连续子数组 最大和
     *  dp[i] 从截止 和最大的 连续子数组  以第i个数结尾的 连续子数组的最大和
     *  关系式 dp[0] =nums[0]    dp[i] =  max( dp[i-1] ,dp[i-1]+nums[i],nums[i])
     *  i [-2,1,-3,4]   i-1 [-2,1,-3]
     *  dp[i] = dp[i-1] +nums[i] || dp[i-1]
     *  dp[i-1] 如果连续的 +dp[i]
     *                    -
     */
    public static int maxSubArray(int[] nums){        //{-2,1,-3,4,-1,2,1,-5,4}
        int[] dp =new int[nums.length];
        if(nums.length < 1){
            return 0;
        }
        dp[0] = nums[0];
        for(int i= 1 ;i<nums.length;i++){
           dp[i] =  max( dp[i-1]+nums[i],nums[i]);

        }
        int max =0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;

    }
    public static int max(int x,int y){
        int max = x;
       if(y>max){
           max = y;
       }
       return max;

    }
    /**
     * 1.dp[i]为第i天卖出的最大利润
     * 2.关系式 dp[i] = dp[i-1] +nums[i]-nums[i-1]
     *
     *
     */
    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for(int i=1;i<prices.length;i++){

                dp[i] = dp[i-1] +prices[i]-prices[i-1];


        }
        return 0;
    }




}
