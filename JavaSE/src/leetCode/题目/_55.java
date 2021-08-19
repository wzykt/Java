package leetCode.题目;

/**
 * 55. 跳跃游戏
 * <p>
 * 2021/8/1
 *
 * 暴力递归实现，还未转化成动态规划
 */
public class _55 {
    public static boolean canJump(int[] nums) {

        if (nums.length < 1) {
            return false;
        }

        boolean[] tem = new boolean[nums.length + 1];
        tem[nums.length] = true;
        return tem[0];
    }

    /*  暴力递归
        public static boolean process(int[] nums, int index) {
            if (index >= nums.length - 1) {
                return true;
            }
            boolean res = false;
            for (int i = 1; i <= nums[index]; i++) {
                res |= process(nums, index + i);
            }
            return res;
        }
    */
    public static void main(String[] args) {
        int[] nums = {2, 5, 0, 0};
        boolean b = canJump(nums);
        System.out.println(b);
    }
}
