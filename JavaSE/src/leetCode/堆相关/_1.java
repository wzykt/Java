package leetCode.堆相关;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 与堆有关的题目
 * 已知一个几乎有序的数组。几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离一定不超过k，并且k相对于数组长度来说是比较小的。
 * 请选择一个合适的排序策略,对这个数组进行排序。
 */
public class _1 {
    public void sortedArrDistanceLessK(int[] arr, int k) {
        //默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        /*
        改为大根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(new MyComp());
         */
        int index = 0;
        {
            for (; index <= Math.min(arr.length, k); index++) {
                heap.add(arr[index]);
            }
            int i = 0;
            for (; index < arr.length; i++, index++) {
                heap.add(arr[index]);
                arr[i] = heap.poll();
            }
            while (!heap.isEmpty()) {
                arr[i++] = heap.poll();
            }
        }
    }

    public static class MyComp implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}