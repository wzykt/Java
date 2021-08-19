package 牛客.Offer;

import java.util.ArrayList;

/**
 * JZ42 和为S的两个数字
 * <p>
 * 2021/7/27
 */
public class JZ42 {
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if(array.length < 2){
            return new ArrayList<Integer>();
        }
        int left = 0;
        int right = array.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (left < right) {
            int tem = array[left] + array[right];
            if (tem > sum) {
                right--;
            }
            if (tem < sum) {
                left++;
            }
            if(tem == sum){
                list.add(array[left]);
                list.add(array[right]);
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = {1,2,4,7,11,15};
        ArrayList<Integer> list = FindNumbersWithSum(array, 15);
        System.out.println(list.toString());
    }
}
