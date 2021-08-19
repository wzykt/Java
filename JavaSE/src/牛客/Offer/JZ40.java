package 牛客.Offer;

import java.util.*;

/**
 *
 * 2021/7/27
 *
 * JZ40	数组中只出现一次的数字
 *
 * 完成
 */
public class JZ40 {
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else {
                map.put(array[i],2);
            }
        }

        int[] result = new int[2];
        int t = 0;
        for (Integer i: map.keySet()) {
            if(map.get((int)i)==1){
                result[t] =  i;
                t++;
            }
        }
        return result;
    }
}
