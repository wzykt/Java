package 牛客.Offer;

import java.util.Arrays;

/**
 * JZ45 扑克牌顺子
 * <p>
 * 2021/7/28
 *
 * 完成
 */
public class JZ45 {
    //数字之间的间隔小于0的数量，既可以表示顺子
    public static boolean IsContinuous(int[] numbers) {
        int[] bucket = new int[14];
        int MaxInterval = 0;
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                MaxInterval++;
            }
            bucket[numbers[i]]++;
        }
        int[] notZero = new int[numbers.length - MaxInterval];
        for (int i = 1; i < bucket.length; i++) {
            if(bucket[i] > 1){
                return false;
            }
            if (bucket[i] == 1) {
                notZero[count] = i;
                count++;
            }
        }
        int interval = 0;
        for (int i = 0; i < notZero.length - 1; i++) {
            interval += notZero[i + 1] - notZero[i] - 1;
        }
        if (interval > MaxInterval) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 2, 6, 4};
        System.out.println(IsContinuous(arr));
    }
}
