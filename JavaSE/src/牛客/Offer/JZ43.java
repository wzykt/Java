package 牛客.Offer;

import java.util.Arrays;

/**
 *
 * JZ45 	左旋转字符串
 *
 * 2021/7/27
 *
 * 完成
 */
public class JZ43 {
    public String LeftRotateString(String str,int n) {
        if(str.isEmpty()){
            return "";
        }
        char[] chars = str.toCharArray();

        char[] chars1 = Arrays.copyOf(chars, n);
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(chars1[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("".length());
    }
}
