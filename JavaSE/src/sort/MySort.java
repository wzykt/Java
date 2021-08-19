package sort;

import java.util.Arrays;

public class MySort {



    /**
    public static void main(String[] args) {
        int[] arr = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};;
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid + 1, right);
    }

    public static void merge(int[] arr, int left, int right, int rightBound) {
        int i = left;
        int j = right;
        int[] tem = new int[rightBound-left+1];
        int k = 0;
        while (i < right && j <= rightBound) {
            if (arr[i] >= arr[j]) {
                tem[k] = arr[j];
                j++;
                k++;
            } else {
                tem[k] = arr[i];
                i++;
                k++;
            }
        }

        while (i < right) {
            tem[k] = arr[i];
            i++;
            k++;
        }
        while (j <= rightBound) {
            tem[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < tem.length; l++) {
            arr[left + l] = tem[l];
        }

    }*/
}
