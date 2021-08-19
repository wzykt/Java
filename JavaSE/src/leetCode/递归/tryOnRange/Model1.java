package leetCode.递归.tryOnRange;

public class Model1 {
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //谁大谁获胜
        return Math.max(
                f(arr, 0, arr.length - 1),
                s(arr, 0, arr.length - 1));
    }

    public static int f(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        return Math.max(arr[L] + s(arr, L + 1, R), arr[R] + s(arr, L, R - 1));
    }

    public static int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    public static void main(String[] args) {
        int[] index= {10,20,5,25,40,100,30,50,15};
        int[] temp = {3,100,7};
        int i = win1(index);
        int j = win1(temp);
        System.out.println(j);
    }
}