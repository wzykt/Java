package sort;

/**
 * 归并排序
 *
 * 先完成数组的归并操作，在进行递归操作，分布操作
 */
public class MergeSort {


    public static void main(String[] args) {

        //int[] arr = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        int[] arr = {1, 4, 7, 8, 3, 6, 9};
        sort(arr,0, arr.length-1);
        print(arr);
    }

    private static void sort(int[] arr, int left, int right) {
        //如果数组只有一个元素，不用排序
        if (left == right) return;
        int mid = (left + right) / 2;
        //左边数组排序
        sort(arr, left, mid);
        //右边数组排序
        sort(arr, mid + 1, right);
        merge(arr, left, mid + 1, right);
    }

    //进行归并的，并不是用来递归的
    //将数组进行排序
    private static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];
        //左边数组的指针
        int i = leftPtr;
        //右边数组的指针
        int j = rightPtr;
        //新数组的指针
        int k = 0;

        while (i <= mid && j <= rightBound) {
            //三目运算符
            //如果arr[i] <= arr[j]就将arr[i]的值放到temp[k]的位置，i和k分别加一，否则arr[j]的值放到temp[k]的位置，j和k分别加一。
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        //
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= rightBound) temp[k++] = arr[j++];

        //将归并后的数组temp数组的值覆盖原数组arr中值
        for (int l = 0; l < temp.length; l++) {
            arr[leftPtr+l] = temp[l];
        }
    }



/*

        //1.子程序最初阶段
        private static void merge(int[] arr) {
        int mid = arr.length / 2;
        int[] temp = new int[arr.length];
        //左边数组的指针
        int i = 0;
        //右边数组的指针
        int j = mid + 1;
        //新数组的指针
        int k = 0;

        while (i <= mid && j < arr.length) {
            //三目运算符
            //如果arr[i] <= arr[j]就将arr[i]的值放到temp[k]的位置，i和k分别加一，否则arr[j]的值放到temp[k]的位置，j和k分别加一。
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
            //if(arr[i]<=arr[j]){
            //    temp[k++] = arr[i++];
            //}else{
            //    temp[k++] = arr[j++];
            //}
        }

        //将左边数组中没放进新数组的值放到新数组中
        while (i <= mid) temp[k++] = arr[i++];
        //将右边数组中没放进新数组的值放到新数组中
        while (j < arr.length) temp[k++] = arr[j++];
    }

 */

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int index = arr[i];
        arr[i] = arr[j];
        arr[j] = index;
    }


}
