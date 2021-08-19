package leetCode.题目;

/**
 * 97. 交错字符串
 *
 * @date 2021/6/2
 */
public class _97 {

    //动态规划
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s1.length()+s2.length()) return false;
        if(s3.length()==0) return true;
        if (s3.length()==1&&(s3.equals(s1)||s3.equals(s2))) return true;
        int rows = s1.length() + 1;
        int cols = s2.length() + 1;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        boolean[][] dp = new boolean[rows][cols];//s1:0~N，s2:0~N
        dp[rows-1][cols-1] = true;
        //最后一行
        for (int col = cols-2; col >=0; col--) {
            if(c2[col]==c3[rows-1+col]){
                dp[rows-1][col] = dp[rows-1][col+1];
            }
        }
        //最后一列
        for(int row = rows-2;row>=0;row--){
            if(c1[row]==c3[row+cols-1]){
                dp[row][cols-1] = dp[row+1][cols-1];
            }
        }
        for (int row = rows-2; row >=0; row--) {
            for (int col = cols-2; col >=0 ; col--) {
                if(c1[row]==c3[row+col]){
                    dp[row][col] |= dp[row+1][col];
                }
                if(c2[col]==c3[row+col]){
                    dp[row][col] |= dp[row][col+1];
                }
            }
        }
        return dp[0][0];
    }


    //暴力递归
    public static boolean process(char[] c1, char[] c2, char[] c3, int indexC1, int indexC2) {
        if (indexC1 == c1.length && indexC2 == c2.length) {
            return true;
        }
        boolean res = false;
        if (indexC1 < c1.length && c1[indexC1] == c3[indexC1 + indexC2]) {
            res = process(c1, c2, c3, indexC1 + 1, indexC2);
        }
        if (indexC2 < c2.length && c2[indexC2] == c3[indexC1 + indexC2]) {
            res |= process(c1, c2, c3, indexC1, indexC2 + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        //String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        //String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        String s1 = "a", s2 = "b", s3 = "ab";
        boolean interleave = isInterleave(s1, s2, s3);
        System.out.println(interleave);
    }
}
