package leetCode.题目;

/**
 * 198. 打家劫舍
 *
 * @date 2021-5-25 通过
 */
public class _198 {

    public static int rob(int[] nums) {
        //动态规划
        int N = nums.length;
        int[] dp = new int[N + 2];
        for (int i = N - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 2] + nums[N-i-1], dp[i + 1]);
        }
        return dp[0];
        //return process(nums,  0);
    }

    //暴力递归
    public static int process(int[] nums, int index) {

        if (index >= nums.length) {
            return 0;
        }
        return Math.max(process(nums, index + 2) + nums[index], process(nums, index + 1));

    }


    public static void main(String[] args) {
        int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        int rob = rob(nums);
        System.out.println(rob);
    }
}
