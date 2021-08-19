package leetCode.题目;

import java.util.ArrayList;

/**
 * 446. 等差数列划分 II - 子序列
 * 2021/8/11
 * <p>
 * 思路一：暴力获取全部子序列，判断是否符合
 * 思路二：双指针
 *
 * 未解决
 *
 * 思路二：不对，不同的子序列也应该算作一种结果
 *
 */
public class _446 {
    public static int numberOfArithmeticSlices(int[] nums) {
        int begin = 0;
        int end = begin + 1;
        int index;
        ArrayList<Integer> tem;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int result = 0;
        int distance;
        while (begin < nums.length - 1) {
            for (int i = end; i < nums.length; i++) {
                tem = new ArrayList<>();
                tem.add(nums[begin]);
                int t = i;
                index = begin;
                distance = nums[t] - nums[begin];
                while (t < nums.length) {
                    if (nums[t] - nums[index] == distance) {
                        tem.add(nums[t]);
                        index = t;
                        t++;
                    } else {
                        t++;
                    }
                    if (tem.size() >= 3) {
                        for (ArrayList<Integer> l : list) {
                            if (l.equals(tem)) {
                                break;
                            }
                        }
                        list.add(tem);
                        result++;
                    }
                }
            }
            begin++;
            end = begin + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7};
        System.out.println(numberOfArithmeticSlices(nums));
    }
}
