package leetCode.题目;
/**
 * 494. 目标和
 * 2021/6/7
 *
 * 暴力递归解决，未通过
 *
 * dp没解决
 *
 */
public class _494 {
    public static int findTargetSumWays(int[] nums, int target) {
        if (nums.length < 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] == target) {
            return 1;
        }

        int count = process(target, nums, 0 - nums[0], 0) + process(target, nums, 0 + nums[0], 0);
        return count;

    }

    /*
    暴力递归
     */
    public static int process(int target, int[] nums, int sum, int index) {
        if (index == nums.length - 1 && sum == target) {
            return 1;
        }
        if (index == nums.length - 1 && sum != target) {
            return 0;
        }
        return process(target, nums, sum - nums[index + 1], index + 1) + process(target, nums, sum + nums[index + 1], index + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        //int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        //int[] nums = {0, 1};
        int targetSumWays = findTargetSumWays(nums, 3);
        System.out.println(targetSumWays);
    }
}
