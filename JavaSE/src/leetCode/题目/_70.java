package leetCode.题目;

/**
 * 70. 爬楼梯
 *
 * 2021/6/14 通过
 */
public class _70 {

    public static int climbStairs(int n) {
  /*动态规划通过*/      if (n < 0) {
            return 0;
        }
        int dp[] = new int[n + 2];
        dp[n] = 1;
        for (int i = n-1; i >=0 ; i--) {
            dp[i] = dp[i+2]+dp[i+1];
        }
        return dp[0];
        //return process(n, 0);
    }

    /*
    暴力递归实现，未通过
     */
    public static int process(int n, int step) {
        if (n < 0) {
            return 0;
        }
        if (n == step) {
            return 1;
        }
        if (n < step) {
            return 0;
        }
        return process(n, step + 1) + process(n, step + 2);
    }

    public static void main(String[] args) {
        int i = climbStairs(10);
        System.out.println(i);
    }
}
