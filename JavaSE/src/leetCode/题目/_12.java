package leetCode.题目;

/*
整数转罗马数字

贪心算法
生活中的经验
在以前还使用现金购物的时候，找零钱的时候一般商家会尽量选择面值大的纸币（硬币）给顾客，这样才会使得给顾客的纸币（硬币）张数最少，让顾客点钱的时候更方便。

https://leetcode-cn.com/problems/integer-to-roman/solution/zheng-shu-zhuan-luo-ma-shu-zi-by-leetcode/
 */
public class _12 {

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String str = "";

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                str = str + symbols[i];
                num = num - values[i];
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String s = intToRoman(671);
        System.out.println(s);
    }
}
