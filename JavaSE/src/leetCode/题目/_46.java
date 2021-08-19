package leetCode.题目;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 2021/7/27
 *
 * 完成：借鉴答案
 *
 * 回溯完成
 */
public class _46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        ArrayList<Integer> output = new ArrayList<>();

        for (Integer i : nums) {
            output.add(i);
        }

        process(nums.length, 0, list, output);
        return list;
    }

    public static void process(int n, int index, List<List<Integer>> list, ArrayList<Integer> output) {
        if (index == n) {
            list.add(new ArrayList<>(output));
        }

        for (int i = index; i < n; i++) {
            Collections.swap(output, index, i);
            process(n, index + 1, list, output);
            //状态回溯
            Collections.swap(output, index, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = new ArrayList<>();
        list = permute(nums);
        System.out.println(list.toString());
    }
}
