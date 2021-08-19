package 数据结构.堆;

import java.util.Arrays;

/**
 * 最大堆
 */
public class Heap {

    private int heapSize;
    private int limit;
    private int[] heap;

    public Heap(int limit) {
        heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    public void push(int value) {
        if (heapSize == limit) {
            throw new RuntimeException("ap is full");
        }
        heap[heapSize] = value;
        heapInsert(heap, heapSize++);
    }

    //弹出堆中最大元素，剩下的元素依然保持堆结构
    public int pop() {
        int ans = heap[0];
        swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);
        return ans;
    }

    //构建heap,以下沉的方式构建
    private void heapInsert(int[] arr, int index) {
        // arr[index]
        // arr[index]不比 arr[index父]大了﹐停
        // index = 0;
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //从index位置，往下看，不断的下沉，
    //停:我的孩子都不再比我大;已经没孩子了
    private void heapify(int[] arr, int index, int heapSize) {
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

    public void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

}