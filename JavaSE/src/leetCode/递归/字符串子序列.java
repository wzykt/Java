package leetCode.递归;

import java.util.*;

/**
 * 获取字符串的所有字串
 *
 * 类似深度优先遍历
 */
public class 字符串子序列 {

    public static List<String> subs(String s) {
        String path = "";

        char[] str = s.toCharArray();
        List<String> list = new ArrayList<>();

        process(str, 0, list, path);
        return list;
    }


    public static void process(char[] str, int index, List<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }

        String yes = path + String.valueOf(str[index]);
        process(str, index + 1, ans, yes);
        String no = path;
        process(str, index + 1, ans, no);
    }


    public static void main(String[] args) {
        String abc = "abca";
        List<String> list = subs(abc);
        System.out.println(list.toString());
    }

}
