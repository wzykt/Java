package leetCode.递归.leftToRightModel;

/*
背包问题

从左往右的尝试模型2
给定两个长度都为N的数组weights和values,
weights[i]和values[i]分别代表i号物品的重量和价值。给定一个正数bag，表示一个载重bag的袋子,
你装的物品不能超过这个重量。
返回你能装下最多的价值是多少?

 */
public class Model2 {
    /*

        //不变: w[]v]bagl / index...最大价值
        // 0..index-1上做了货物的选择，使得你已经达到的重量是多少alreadyw//如果返回-1，认为没有方案
        //如果不返回-1，认为返回的值是真实价值

        public static int process(int[] w, int[] v, int index, int alreadyw, int bag) {
            //重量已超，此分支不行
            if (alreadyw > bag) {
                return -1;
            }
            //重量没超
            if (index == w.length) {
                return 0;
            }
            //没要当前货物
            int p1 = process(w, v, index + 1, alreadyw, bag);
            //要了当前货物
            int p2next = process(w, v, index + 1, alreadyw + w[index], bag);
            int p2 = -1;
            if (p2next != -1) {
                p2 = v[index] + p2next;
            }
            return Math.max(p1, p2);
        }
    */


    //只剩下rest的空间了，
    //index...货物自由选择，但是剩余空间不要小于e
    //返回index...货物能够获得的最大价值
    public static int process(int[] w, int[] v, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }

        //有货也有空间
        int p1 = process(w, v, index + 1, rest);
        int p2 = -1;
        int p2Next = process(w, v, index + 1, rest - w[index]);
        if (p2Next != -1) {
            p2 = v[index] + p2Next;
        }
        return Math.max(p1, p2);
    }

    public static int dpway(int[] w, int[] v, int bag) {
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        // dp[ N][...] =0；
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {

                int p1 = dp[index + 1][rest];
                int p2 = -1;

                if (rest - w[index] >= 0) {
                    p2 = v[index] + dp[index + 1][rest - w[index]];
                }
                dp[index][rest] = Math.max(p1, p2);
                System.out.print(dp[index][rest]+" ");
            }
            System.out.println();
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = {3,2,4,7 };
        int[] values = {5,6,3,19 };
        int bag = 11;
        System.out.println(process(weights, values,0, bag));
        System.out.println(dpway(weights, values, bag));
    }

}
