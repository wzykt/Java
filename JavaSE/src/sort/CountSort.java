package sort;

import java.util.Arrays;

/**
 * 计数排序
 * <p>
 * 不完整：
 * 如果数字较大，会导致产生较大数组，浪费空间
 * <p>
 * 改进：
 * 定义index数组应该用传入的最大值减去最小值+1作为容量
 * <p>
 * <p>
 * <p>
 * 目前不稳定
 */
public class CountSort {


    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 3, 7, 1, 1, 0, 0, 5, 6, 9, 8, 5, 7, 4, 0, 9};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        //0-10
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        System.out.println(Arrays.toString(count));

//        //不稳定
//        for (int i = 0, j = 0; i < count.length; i++) {
//            while (count[i]-- > 0) {
//                result[j++] = i;
//            }
//        }

        //稳定
        //记录桶的下标最后出现的位置
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        System.out.println(Arrays.toString(count));
        for (int i = arr.length - 1; i >= 0; i--) {
            result[--count[arr[i]]] = arr[i];
        }
        return result;
    }


    static void findMax(int[] a, int n) {
        for (int j = 0; j < n; j++) {
            if (a[j] > a[j + 1])
                swap(a, j, j++);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int index = arr[i];
        arr[i] = arr[j];
        arr[j] = index;
    }

//    public static int[] count(int array[]) {
//        int max = array[0];
//        int t = 0;
//        //找到数组中最大的值，+1作为新数组的大小
//        for (int i = 0; i < array.length; i++){
//            if(array[i] > max){
//                max = array[i];
//            }
//        }
//        int index[] = new int[max+1];
//
//        for(int i = 0;i<array.length;i++){
//            //array[i]对应的下标值++
//            index[array[i]]++;
//        }
//        System.out.println(Arrays.toString(index));
//        int T = 0;
//        int sortArray[] = new int[array.length];
//        for (int i = 0; i < index.length; i++) {
//            for(int j = 0;j < index[i] ; j++){
//                sortArray[T++]=i;
//            }
//        }
//        return sortArray;
//    }
//
//    public static void main(String[] args) {
//        int[] array = new int[]{4,4,6,5,3,2,8,1,7,5,6,0,10};
//        System.out.println("原数组"+Arrays.toString(array));
//        int[] sort = count(array);
//        System.out.println("排序后的数组"+Arrays.toString(sort));
//    }
}
