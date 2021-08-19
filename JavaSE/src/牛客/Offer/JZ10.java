package 牛客.Offer;

/**
 * JZ10
 *
 * 2021/8/4
 *
 * 完成
 * 暴力递归
 * 动态规划
 */
public class JZ10 {
    public int rectCover(int target) {
        int[] res = new int[target+1];
        res[target] =1;
        for (int i = target-1; i >=0 ; i--) {
            res[i] = res[i+1]+res[i+2];
        }
        return res[0];
        //return process(target,0);
    }

    public static int process(int target,int index){
        if(index == target){
            return 1;
        }
        return process(target, index+1)+process(target, index+2);
    }
}
