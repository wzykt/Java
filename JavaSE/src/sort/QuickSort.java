package sort;

import 牛客.TreeNode;

import java.util.Arrays;

/**
 * 快速排序
 * <p>
 * 先找到一个基准值pivot作为轴（以数组最后一个数作为基准值）
 * 比轴小的数都放在左边
 * 必轴大的数都放在右边
 */


public class QuickSort {

    public static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) return;
        int mid = partition(arr, leftBound, rightBound);
        //轴左边进行排序
        sort(arr, leftBound, mid);
        //轴右边进行排序
        sort(arr, mid + 1, rightBound);
        System.out.println(Arrays.toString(arr));
    }

    public static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;

        while (left < right) {
            //left指向小于等于轴的位置
            //left < right
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //right指向大于轴的位置
            while (left < right && arr[right] > pivot) {
                right--;
            }
            //交换left和right
            if (left < right) {
                swap(arr, left, right);
            }
        }
        if (arr[left] > pivot) {
            swap(arr, left, rightBound);
        }


        //返回轴的位置
        return left;
    }
   

    private static void swap(int[] arr, int left, int right) {
        int tar = arr[left];
        arr[left] = arr[right];
        arr[right] = tar;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 2, 10, 8, 1, 9, 5, 4, 6};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}





/*
public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 用分治法递归数列的两部分
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        // 坑的位置，初始等于pivot的位置
        int index = startIndex;
        //大循环在左右指针重合或者交错时结束

        while (right >= left) {
            //right指针从右向左进行比较
            while (right >= left) {
                if (arr[right] < pivot) {
                    arr[left] = arr[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            //left指针从左向右进行比较
            while (right >= left) {
                if (arr[left] > pivot) {
                    arr[right] = arr[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        arr[index] = pivot;
        return index;
    }


 */