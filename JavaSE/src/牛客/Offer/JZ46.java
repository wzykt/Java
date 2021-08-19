package 牛客.Offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * JZ 46
 * <p>
 * 2021/7/30
 *
 * 完成
 */
public class JZ46 {
    public static int LastRemaining_Solution(int n, int m) {
        if (n < 1) {
            return -1;
        }
        Queue<Integer> queue = new ArrayDeque<Integer>(n);
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        int count = 1;
        while (queue.size() != 1) {
            Integer intTem = queue.poll();
            if (count == m) {
                count = 1;
                continue;
            }
            count++;
            queue.add(intTem);
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        int i = LastRemaining_Solution(5, 3);
        System.out.println(i);
    }
}
