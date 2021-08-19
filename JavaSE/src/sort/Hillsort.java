package sort;

import java.util.Arrays;

/**
 * 希尔排序
 * <p>
 * 增量为array.length/2
 */
//public class Hillsort {
//
//    public static void sort(int[] array) {
//        int d = array.length;
//        while (d > 1) {
//        //使用希尔增量的方式，即每次折半
//            d = d / 2;
//            for (int x = 0; x < d; x++) {
//                for (int i = x + d; i < array.length; i = i + d) {
//                    int temp = array[i];
//                    int j;
//                    for (j = i - d; j >= 0 && array[j] > temp; j = j - d) {
//                        array[j + d] = array[j];
//                    }
//                    array[j + d] = temp;
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] array = {5, 3, 9, 12, 6, 1, 7, 2, 4, 11, 8, 10};
//        sort(array);
//        System.out.println(Arrays.toString(array));
//    }
//
//}

public class Hillsort {

    public static void main(String[] args) {

        int[] arr = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        sort(arr);
        print(arr);
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

//    //间隔gap=4适合小数组排序
//    private static void sort(int[] arr) {
//        //每隔gap个进行一次排序，相当于每隔gap个进行插入排序
//        for (int gap = 4; gap > 0; gap /= 2) {
//            //就是插入排序，排序间隔为gap
//            for (int i = gap; i < arr.length; i++) {
//                for (int j = i; j > gap - 1; j -= gap) {
//                    if (arr[j] < arr[j - gap]) {
//                        swap(arr, j, j-gap);
//                    }
//                }
//            }
//        }
//    }

    //令间隔为数组长度的一半,使其时候所以数组，但是效率仍不是最高的
    private static void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j = j - gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j, j - gap);
                    }
                }
            }
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int index = arr[i];
        arr[i] = arr[j];
        arr[j] = index;
    }

}