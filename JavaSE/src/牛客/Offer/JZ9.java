package 牛客.Offer;

import java.util.ArrayList;

/**
 *
 * JZ9
 *
 * 2021/8/4
 *
 * 完成
 * 动态规划
 * 暴力递归
 *
 */
public class JZ9 {
    /*
    public int[] reOrderArray (int[] array) {
        // write code here
        int[] result = new int[array.length];
        int count = 0;
        for(int i =0;i < array.length;i++){
            if(array[i] % 2 != 0){
                result[count] = array[i];
                count++;
            }
        }
        for(int i =0;i < array.length;i++){
            if(array[i] % 2 == 0){
                result[count] = array[i];
                count++;
            }
        }
        return result;
    }*/
    public static int jumpFloorII(int target) {
        int process = process(target, 0);
        int[] res = new int[target + 2];
        res[target] = 1;
        res[target + 1] = 0;
        for (int i = target - 1; i >= 0; i--) {
            for (int j = 1; j <= target; j++) {
                if (i + j < res.length - 1) {
                    res[i] += res[i + j];
                }
            }
        }
        return res[0];
    }

    public static int process(int target, int index) {
        int sum = 0;
        if (index > target) {
            return 0;
        }
        if (index == target) {
            return 1;
        }
        for (int i = 1; i <= target; i++) {
            sum += process(target, i + index);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(jumpFloorII(3));
    }
}
