package leetCode.题目;

public class _14 {


    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs1 = {"dog", "racecar", "car"};
        String[] strs2 = {"ab", "a"};
        String[] strs3 = {"flower", "flower", "flower", "flower"};
        String s;
        System.out.println(s = longestCommonPrefix(strs));
        System.out.println(s = longestCommonPrefix(strs1));
        System.out.println(s = longestCommonPrefix(strs2));
        System.out.println(s = longestCommonPrefix(strs3));
    }

}
