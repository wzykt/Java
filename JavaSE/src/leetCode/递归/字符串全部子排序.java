package leetCode.递归;

import java.util.*;

public class 字符串全部子排序 {

    public static ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        return res;
    }
    //str[0..i-1]已经做好决定的
    //str[i...]都有机会来到i位置
    //i终止位置，str当前的样子，就是一种结果-> ans
    public static void process(char[] temp, int index, List<String> list) {
        if (index == temp.length) {
            list.add(String.valueOf(temp));
        }
        for (int i = index; i < temp.length; i++) {
            swap(temp, index, i);
            process(temp, index + 1, list);
            //恢复原状
            swap(temp, index, i);
        }
    }

    public static void swap(char[] temp, int i, int j) {
        char T = temp[i];
        temp[i] = temp[j];
        temp[j] = T;
    }

    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> permutation = permutation(s);
        System.out.println(permutation.toString());

    }
}
