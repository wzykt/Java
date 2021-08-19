package leetCode.Offer;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 *
 * 2021/6/28
 *
 * （约瑟夫环）纯数学解法
 *  推理过程：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
 */
public class Offer62 {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        //(当前index + m) % 上一轮剩余数字的个数
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

}
