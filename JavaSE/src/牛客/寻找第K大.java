package 牛客;

import com.sun.crypto.provider.DESCipher;

import java.util.Arrays;

public class 寻找第K大 {
//    public static int findKth(int[] a, int n, int K) {
//        Arrays.sort(a);
//        return a[n-K];
//    }

    public static int findKth(int[] a, int n, int K) {
        sort(a, 0, n-1);
        return a[n - K];
    }

    public static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) return;
        int pivot = partition(arr, leftBound, rightBound);
        sort(arr, leftBound, pivot);
        sort(arr, pivot + 1, rightBound);
    }

    public static int partition(int[] arr, int leftBound, int rightBound) {
        int povit = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;

        while (left < right) {
            while (left < right && arr[left] <= povit) {
                left++;
            }
            while (left < right && arr[right] > povit) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        if (arr[left] > povit) {
            swap(arr, left, rightBound);
        }
        return left;
    }

    public static void swap(int[] arr, int left, int right) {
        int T = arr[left];
        arr[left] = arr[right];
        arr[right] = T;
    }


    public static void main(String[] args) {
        int[] nums = {1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891, 1884022, 252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742, 883142, 259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799, 1959818, 1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786, 937247, 986578, 798663};
        int kth = findKth(nums, nums.length, 24);
        System.out.println(kth);
    }
}
