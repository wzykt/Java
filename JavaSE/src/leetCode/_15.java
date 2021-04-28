package leetCode;
/*
三数之和

标签：数组遍历
首先对数组进行排序，排序后固定一个数 nums[i]nums[i]，再使用左右指针指向 nums[i]nums[i]后面的两端，数字分别为 nums[L]nums[L] 和 nums[R]nums[R]，计算三个数的和 sumsum 判断是否满足为 00，满足则添加进结果集
如果 nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
如果 nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
当 sumsum == 00 时，nums[L]nums[L] == nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++L++
当 sumsum == 00 时，nums[R]nums[R] == nums[R-1]nums[R−1] 则会导致结果重复，应该跳过，R--R−−
时间复杂度：O(n^2)  n为数组长度

 */

import java.util.*;

public class _15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }

    /*
     无法解决int nums2[] = {0,0,0,0,0,0,0};
     输出[[0, 0, 0], [0, 0, 0], [0, 0, 0], [0, 0, 0], [0, 0, 0]]

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> allList = new ArrayList<>();
        if (nums.length < 3|| nums[0] > 0 ) {
            return allList;
        }

        for (int i = 0; i < nums.length; i++) {

            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                if ((nums[i] + nums[L] + nums[R]) == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    allList.add(list);
                }
                while(L<R && nums[L + 1] == nums[L]) L++;
                while(L<R && nums[R - 1] == nums[R]) R--;
                L++;
                R--;
            }
        }

        return allList;
    }
*/
    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        int nums1[] = {1,2,3,4,5,6,7,8,9};
        int nums2[] = {0,0,0,0,0,0,0};
        System.out.println(threeSum(nums).toString());
        System.out.println(threeSum(nums1).toString());
        System.out.println(threeSum(nums2).toString());
    }
}
