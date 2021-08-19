package 数据结构.堆;

/**
 * 堆排序
 *
 * 时间复杂度：O(N*logN)
 *
 * 堆排序额外空间复杂度O(1)
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //O(N*logN)
        for (int i = 0; i < arr.length; i++) {//O(N)
            heapInsert(arr, i); // O(logN)
        }
        //优化    0
        //O(N)
        //for (int i = arr.length - 1; i 0; i--) {
        // heapify(arr, i, arr.length);
        //}
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        //O(N*logN)
        while (heapSize > 0) {//O(N)
            heapify(arr, 0, heapSize);//O(logN)
            swap(arr, 0, --heapSize);//O(1)
        }
    }

    //从index位置，往下看，不断的下沉，
    //停:我的孩子都不再比我大;已经没孩子了
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            //左右两个孩子中，谁大，i谁把自己的下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    //larr[index]刚来的数，往上
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
}
