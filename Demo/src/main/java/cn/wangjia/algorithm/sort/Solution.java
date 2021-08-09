package cn.wangjia.algorithm.sort;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/8/3
 */
public class Solution {


    public static void main(String[] args) {
        //int[] nums1 = {9,2,7,-2,11,-8};
        //selectSort(nums1);
        //System.out.println("xxx");
        byte[] body= new byte[100];
        String head = String.valueOf(body.length+2);
        while(head.length() < 10){
            head = "0"+ head;
        }
       ctx.head = head+"00"+new String(body);









    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        for(int i=0;i< n;i++){

            nums1[i+n] = nums2[i];
        }
        for(int i=0;i<nums1.length;i++){

            for(int j =0;j<nums1.length -i -1;j++){

                if(nums1[j]>nums1[j+1]){
                    nums1[j] = nums1[j] +nums1[j+1];
                    nums1[j+1] = nums1[j] - nums1[j+1];
                    nums1[j] = nums1[j] - nums1[j+1];
                }
            }
        }




    }
    public  static  int[] selectSort(int[] nums){
        //选择排序
        for(int i =0; i<nums.length-1;i++){
            int selct = nums[i];
            int latest = 0;
            int index =0;
            for(int j=i+1 ; j < nums.length-1;j++){
                 index = j;
                 latest = nums[j];
                if(latest < nums[j+1]){
                    latest = nums[j+1];
                    index= j+1;
                }
                System.out.println("此次循环最小的数为:"+latest);
            }
            if(selct<latest){
                nums[i] = nums[i]+nums[index];
                nums[index] = nums[i] -nums[index];
                nums[i] = nums[i] -nums[index];
            }

       }
        return nums;




    }

}
