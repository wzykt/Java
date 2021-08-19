package leetCode.题目;

/**
 * 62. 不同路径
 *
 * 2021/6/14
 *
 * 通过
 */
public class _62 {
    public static int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        int[][] dp = new int[m + 2][n + 2];
        dp[m][n] = 1;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (j == n - 1) {
                    dp[i][j] = dp[i + 1][j];
                }
                if (i == m - 1) {
                    dp[i][j] = dp[i][j + 1];
                }
                if (j < n || i < m) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[1][1];
        //return process(m, n, 1, 1);
    }

    //int[M][N]
    public static int process(int m, int n, int indexM, int indexN) {
        if (indexM > m || indexN > n) {
            return 0;
        }

        if (indexM == m && indexN == n) {
            return 1;
        }
        if (indexM == m) {
            return process(m, n, indexM, indexN + 1);
        }
        if (indexN == n) {
            return process(m, n, indexM + 1, indexN);
        }
        return process(m, n, indexM + 1, indexN) + process(m, n, indexM, indexN + 1);
    }

    public static void main(String[] args) {
        int result = uniquePaths(3, 7);
        System.out.println(result);
    }
}

