package leetCode.题目;

public class _53 {
    //贪心算法
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum =sum + nums[i];
            if(sum < nums[i]){
                sum =nums[i];
            }
            max = Math.max(sum,max);
        }
        return max;

    }


    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }
}
