package 牛客.Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * JZ34 第一个只出现一次的字符
 * <p>
 * 2021/7/26
 *
 * 完成：借鉴答案
 */
public class JZ34 {
    public static int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> site = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (site.containsKey(str.charAt(i))) {
                //重复则value==2
                site.put(str.charAt(i), 2);
            } else site.put(str.charAt(i), 1);

        }
        //遍历字符串
        for (int i = 0; i < str.length(); i++) {
            //找到value值为1的数
            if (site.get(str.charAt(i)) == 1)
                return i;
        }

        return -1;
    }


    public static void main(String[] args) {
        String s = "gooogle";
        System.out.println(FirstNotRepeatingChar(s));
    }
}
