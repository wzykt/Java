package leetCode.题目;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 为解决
 */

public class _215 {

    public static int findKthLargest(int[] nums, int k) {
        //PriorityQueue默认最小堆，传入比较器改为最大堆
        PriorityQueue<Integer> heap = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }

        int i = 1;
        int result = 0;
        while (!heap.isEmpty()) {
            if (i == k) {
                result = heap.poll();
            }
            System.out.println(heap.poll());
            i++;
        }
        return result;
    }

//    public static int findKthLargest(int[] nums, int k) {
//        if (nums.length < k && nums.length == 0) {
//            return 0;
//        }
//        Heap heap = new Heap(1000);
//        for (int i = 0; i < nums.length; i++) {
//            heap.push(nums[i]);
//        }
//        int tar = 0;
//        int i = 1;
//        while(!heap.isEmpty()){
//            if(i == k){
//                tar = heap.pop();
//                break;
//            }
//            heap.pop();
//            i++;
//        }
//        return tar;
//    }

//    public static int heapify(int[] nums, int index) {
//        int i = 0;
//        if(i==index){
//            return nums[index];
//        }
//        swap(nums, i, index);
//        int maxIndex = nums[2 * i + 1] >= nums[2 * i + 2] ? (2 * i + 1) : (2 * i + 2);
//        while (nums[i] <= nums[maxIndex]) {
//            swap(nums, i, maxIndex);
//            i = maxIndex;
//            if ((2 * i + 1) >= (index - 1)) {
//                break;
//            }
//            maxIndex = nums[2 * i + 1] >= nums[2 * i + 2] ? (2 * i + 1) : (2 * i + 2);
//        }
//        return nums[index];
//    }
//
//    public static void heapInsert(int[] arr, int i) {
//        int index = i;
//        while (arr[index] > arr[(index - 1) / 2]) {
//            swap(arr, index, (index - 1) / 2);
//            index = (index - 1) / 2;
//        }
//    }
//
//    public static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }

    public static void main(String[] args) {
        //int[] nums = {3, 2, 1, 5, 6, 4};
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        //int[] nums = {2,1};
        System.out.println("result = "+findKthLargest(nums, 3));
    }
}
