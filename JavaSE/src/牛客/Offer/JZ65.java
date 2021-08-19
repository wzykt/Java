package 牛客.Offer;

/**
 * JZ65 矩阵中的路径
 * <p>
 * 2021/8/10
 *
 * 暴力递归，超时。未弄明白代码的回溯
 */
public class JZ65 {
    public static boolean hasPath(char[][] matrix, String word) {
        if (matrix == null || word == null) {
            return false;
        }
        StringBuilder temStr = new StringBuilder();
        int[][] tem = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (process(matrix, temStr, i, j, tem, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean process(char[][] matrix, StringBuilder s, int x, int y, int[][] tem, String word) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || tem[x][y] == 1 || s.length() > word.length()) {
            return false;
        }
        StringBuilder temStr = s;
        s.append(matrix[x][y]);
        System.out.println(s.toString());
        if (word.equals(s.toString())) {
            return true;
        }
        tem[x][y] = 1;

        boolean b1 = process(matrix, s, x, y + 1, tem, word);

        boolean b2 = process(matrix, s, x+1, y, tem, word);

        boolean b3 = process(matrix, s, x - 1, y, tem, word);

        boolean b4 = process(matrix, s, x, y - 1, tem, word);
        s.deleteCharAt(s.length()-1);
        tem[x][y] = 0;
        return b1 || b2 || b3 || b4;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};

        String word = "abcce";
        System.out.println(hasPath(matrix, word));
    }

}

class Solution {
    public boolean hasPath (char[][] matrix, String word) {
        char[] words = word.toCharArray();
        //遍历数组matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs(matrix, words, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    //进行判断，其中k是目标字符的索引
    boolean dfs(char[][] matrix, char[] word, int i, int j, int k) {
        //进行特判
        //返回false的有：行或列越界，元素不匹配
        if (i > matrix.length -1 || i < 0 || j > matrix[0].length -1 || j < 0
                || matrix[i][j] != word[k]){
            return false;
        }
        if(k == word.length - 1){
            return true;
        }
        //为了防止标记字符与矩阵原有字符重复，遍历后置空
        matrix[i][j] = '\0';
        //搜索下一单元格:朝当前元素的 上、下、左、右 四个方向开启下层递归
        //使用或连接(代表只需找到一条可行路径就直接返回,不再做后续 DFS)
        //并记录结果至 res
        boolean res = dfs(matrix, word, i + 1, j, k + 1)
                || dfs(matrix, word, i - 1, j, k + 1)
                || dfs(matrix, word, i, j + 1, k + 1)
                || dfs(matrix, word, i, j - 1, k + 1);
        //还原当前矩阵元素:将board[i][j]元素还原至初始值,即word[k]
        //递归之前置空了，现在要把它还原回去
        matrix[i][j] = word[k];
        //最终返回
        return res;
    }
}