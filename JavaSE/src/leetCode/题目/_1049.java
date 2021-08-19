package leetCode.题目;

import java.util.Arrays;

/**
 *
 * 1049. 最后一块石头的重量 II
 *
 * 2021/6/8
 */
public class _1049 {

    public static int lastStoneWeightII(int[] stones) {

        System.out.println(Arrays.toString(stones));
        return 0;
    }

    public static void process(int[] stones,int index,int stonesLength){
        if(index >= stonesLength){
            return;
        }

    }

    public static void main(String[] args) {
        //int[] stones = {2,7,4,1,8,1};
        int[] stones = {31,26,33,21,40};
        //int[] stones = {1,2};
        int result = lastStoneWeightII(stones);
        System.out.println(result);
    }
}
