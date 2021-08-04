package cn.wangjia.algorithm.sort;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/8/3
 */
public class Solution {


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[]  nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println("xxx");
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

}
