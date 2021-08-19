package leetCode.题目;

/**
 * 374. 猜数字大小
 *
 * 2021/6/14 通过
 */
public class _374 {

    public static int guessNumber(int n) {
//        正确答案
//        int left = 1, right = n;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (guess(mid) <= 0) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;

        /*   无法解决界限问题
        int pivot = (n + 1) / 2;
        while (pivot != n) {
            System.out.println(pivot);
            if (guess(pivot, n) > 0) {
                pivot = (pivot + n) / 2;
            } else if (guess(pivot, n) < 0) {
                pivot = (pivot + 1) / 2;
            }
        }
        return pivot;
        */
        return 0;
    }

    public static int guess(int pick, int num) {
        return pick - num;
    }


    public static void main(String[] args) {
        guessNumber(10);
    }
}
