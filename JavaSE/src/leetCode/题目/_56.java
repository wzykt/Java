package leetCode.题目;

/**
 *
 * @date 2021-5-15
 *
 */
public class _56 {

    public static void main(String[] args) {
        int N = 13;
        int[] record = new int[N];
        int process = process(0, record, N);
        System.out.println(process);
    }

    /**
     * @param i:当前层数
     * @param record：i层之前皇后所在的位置  record[0]=2 表示第一层皇后在第2列
     * @param n；皇后数量
     * @return res: 可能次数
     */
    public static int process(int i,int[] record,int n){
        if(i == n){
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if(isValid(record, i, j)){
                record[i] = j;
                res += process(i+1, record, n);
            }
        }
        return res;
    }

    /**
     * @param record:i层之前皇后所在的位置  record[0]=2 表示第一层皇后在第2列
     * @param i: 当前层数
     * @param j；皇后数量
     * @return
     */
    public static boolean isValid(int[] record,int i,int j){
        for (int k = 0; k < i; k++) {
            //k,i表示行，record[k],j表示列，[k-i]=[record[k]-j]时表示位于对角线上
            if(record[k]==j||Math.abs(k-i)==Math.abs(record[k]-j)){
                return false;
            }
        }
        return true;
    }

}
