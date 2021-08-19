package 蓝桥杯;

import java.util.LinkedList;

/*
给定数列1, 1, 1, 3, 5, 9, 17, …，从第4 项开始，每项都是前3 项的和。求
第20190324 项的最后4 位数字。
 */
public class _11 {
    public static void main(String[] args) {
        int[] arr = new int[20190324];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 3; i < 20190324; i++){
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
            arr[i] %= 10000;
        }
        System.out.println(arr[20190323]);
    }

}
