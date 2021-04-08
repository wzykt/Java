package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
无重复字符的最长子串
 */
public class _3 {

    //
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                start = Math.max(map.get(ch)+1,start);
                System.out.println("start->"+start);
            }
            max = Math.max(max,end - start + 1);
            System.out.println("max->"+max);
            map.put(ch,end);
        }
        return max;
    }


    public static void main(String[] args) {
        String s1 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s1));
//        String s2 = "hellosworld";
//        System.out.println(lengthOfLongestSubstring(s2));
        //String s3 = "abcabcbb";
        //System.out.println(lengthOfLongestSubstring(s3));
        //System.out.println(lengthOfLongestSubstring(" "));
    }
}


/*
    public static int lengthOfLongestSubstring(String s) {

        int len = s.length();
        if (s.equals(" "))
            return 1;
        if (len == 0)
            return 0;
        int max = 0;
        int t = 0;
        StringBuffer stringBuffer = new StringBuffer(s.substring(0, 1));
        for (int i = 1; i < len; i++) {
            String index = s.substring(i, i + 1);
            if (stringBuffer.indexOf(index) < 0) {
                stringBuffer.append(index);
                //System.out.println("->"+stringBuffer);
            } else {
                if (stringBuffer.length() > max) {
                    max = stringBuffer.length();
                }
                t = stringBuffer.indexOf(index);
                i = i - t;
                stringBuffer.delete(0, stringBuffer.length());
                stringBuffer.append(s.substring(i, i + 1));
                //System.out.println(stringBuffer);
            }
            if (stringBuffer.length() > max) {
                max = stringBuffer.length();
            }
        }
        return max;*/