package leetCode.题目;

/**
 * 32. 最长有效括号
 * 2021/6/21
 */
public class _32 {
    public int longestValidParentheses(String s) {
        char[] str = new char[s.length()];
        return 0;
    }

    public static int process(int index, int sum, char str[]) {
        if (index == str.length) {
            return 0;
        }
        if ((str[index] + str[index] + "").equals("()")) {
            return Math.max((1+process(index + 2, sum + 1, str)),sum);
        } else {
            return process(index + 1, sum , str);
        }


    }
}
