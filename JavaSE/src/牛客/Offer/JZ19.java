package 牛客.Offer;

import java.util.ArrayList;

/**
 * @date 2021/7/20
 *
 * 未完成
 */
public class JZ19 {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int bottom = matrix[0].length-1;
        int top = 0;
        int left = 0;
        int right = matrix.length-1;
        if(matrix.length < 2){
            list.add(matrix[0][0]);
        }
        while(top <= bottom && left <= right){
            for(int i = left;i <= right;i++){
                list.add(matrix[top][i]);
            }
            top++;
            for(int i = top;i <= bottom ;i++){
                list.add(matrix[i][right]);
            }
            right--;
            for(int i = right;i >= left;i--){
                list.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i = bottom;i >= top;i--){
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        ArrayList<Integer> list = printMatrix(matrix);

        
        System.out.println(list.toString());
    }
}
