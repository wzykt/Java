package 牛客.Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 2021/7/25
 *
 * 完成：效率不高
 *
 */
public class JZ28 {

    public static int MoreThanHalfNum_Solution(int [] array) {
       Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])){
                int tem = map.get(array[i]);
                map.put(array[i], tem+1);
            }else{
                map.put(array[i],1);
            }
        }

        int result = 0;
        for (Integer key:map.keySet()) {
            if(map.get(key) > array.length/2){
                result = key;
            }
        }
        return result;
    }

    /*
    参考评论
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int mid = (array.length-1)/2;
        return array[mid];
    }
     */

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        int i = MoreThanHalfNum_Solution(array);
        System.out.println(i);
    }
}
