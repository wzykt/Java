package sort;

import jdk.nashorn.internal.ir.BinaryNode;

import java.util.Arrays;

/**
 * Radix sort 基数排序
 * <p>
 * 多关键字排序
 * <p>
 * 桶排序的思想
 */
public class RadixSort {

    public static void main(String[] args) {
        int arr[] = {421, 240, 115, 532, 305, 430, 124};
        int result[] = sort(arr);
        System.out.println(Arrays.toString(result));



    }

    static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        //0-10
        int[] count = new int[10];
        for (int i = 0; i < 3; i++) {
            int division = (int) Math.pow(10, i);

            for (int j = 0; j < arr.length; j++) {
                int num = arr[j]/division%10;
                count[num]++;
            }

            System.out.println(Arrays.toString(count));

            for (int m = 1; m < count.length; m++) {
                count[m] = count[m] + count[m - 1];
            }
            System.out.println(Arrays.toString(count));
            for (int n = arr.length - 1; n >= 0; n--) {
                int num = arr[n]/division%10;
                result[--count[num]] = arr[n];
            }
            System.arraycopy(result,0,arr,0,arr.length);
            Arrays.fill(count,0);
        }
        return result;
    }

    private static void swap(int[] arr, int i, int j) {
        int index = arr[i];
        arr[i] = arr[j];
        arr[j] = index;
    }

}
