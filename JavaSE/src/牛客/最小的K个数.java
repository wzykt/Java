package 牛客;


import java.util.ArrayList;
import java.util.*;

public class 最小的K个数 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k> input.length){
            return null;
        }
        Arrays.sort(input);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        int k =4;
        System.out.println(GetLeastNumbers_Solution(input,k).toString());

    }
}
