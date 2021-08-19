package leetCode.题目;

import java.util.Arrays;

/*
最接近的三数之和

类似于三数之和

排序+双指针
 */
public class _16 {
    public static int myThreeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int sum = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length-1;
            if(left >= right){
                break;
            }
            while (left<right){
                int tar = nums[i]+nums[left]+nums[right];
                if(target<0&&(target-tar) > (target-sum)){
                    sum = tar;
                }
                if(target>=0&&(target+tar) > (target+sum)){
                    sum = tar;
                }
                //target>0&&
                if(tar<target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return sum;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if (sum > target)
                    end--;
                else if (sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,1};
        int[] nums1 = {-1,2,1,-4};
        int[] nums2 = {0,2,1,-3};
        int i = threeSumClosest(nums2, 1);
        System.out.println(i);
    }
}
