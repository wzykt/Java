package leetCode.题目;

import java.util.Arrays;

/**
 * 旋转数组
 */
public class _189 {
    /*
    先反转全部数组，在反转前k个，最后在反转剩余的
     */
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums, 0, length - 1);//先反转全部的元素
        reverse(nums, 0, k - 1);//在反转前k个元素
        reverse(nums, k, length - 1);//接着反转剩余的
    }

    public static void reverse(int[] nums,int begin,int end){
//        for (int i = 0; i <= (end-begin)/2; i++) {
//            int temp = nums[end-i];
//            nums[end-i] = nums[begin+i];
//            nums[begin+i] = temp;
//        }
        while (begin < end) {
            int temp = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = temp;
        }   
    }

    public static void main(String[] args) {
        int[] nums = {1};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }
}
