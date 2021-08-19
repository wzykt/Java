package leetCode.题目;

/**
 * 删除有序数组中的重复项
 *
 * @date 2021-5-13
 */
public class _26 {
    /*
    双指针解决问题

    left等于right，right向右移动一位
    left不等于right，left向右移动一位，将left的值和right的值交换
     */
    public int removeDuplicates(int[] nums) {
        int left=0,right=1;
        while(right<nums.length){
            if(nums[left]==nums[right]){
                right++;
            }else{
                left++;
                nums[left] = nums[right];
            }
        }

        return left+1;
    }
}
