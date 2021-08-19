package leetCode.题目;

/**
 * 64. 最小路径和
 *
 * 2021/6/15
 *
 * 通过
 */
public class _64 {
    public static int minPathSum(int[][] grid) {
        if (grid.length < 0 || grid[0].length < 0) {
            return 0;
        }

        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        dp[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
        //System.out.println("dp[grid.length - 1][grid[0].length - 1] = " + dp[grid.length - 1][grid[0].length - 1]);
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (j == grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                    continue;
                }
                if (i == grid.length - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                    continue;
                }
                if (i < grid.length - 1 && j < grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
                System.out.println("dp[" + i + "]" + "[" + j + "]" + "=" + dp[i][j]);
            }
        }
        return dp[0][0];
        //return process(grid,0,0);
    }

    public static int process(int[][] grid, int indexN, int indexM) {
        if (grid.length - 1 == indexN && grid[0].length - 1 == indexM) {
            return grid[indexN][indexM];
        }
        if (indexN == grid.length - 1) {
            return grid[indexN][indexM] + process(grid, indexN, indexM + 1);
        }
        if (indexM == grid[0].length - 1) {
            return grid[indexN][indexM] + process(grid, indexN + 1, indexM);
        }
        return grid[indexN][indexM] + Math.min(process(grid, indexN + 1, indexM), process(grid, indexN, indexM + 1));
    }

    public static void main(String[] args) {
        //int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        int result = minPathSum(grid);
        System.out.println(result);
    }
}
