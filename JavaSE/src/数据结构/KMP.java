package 数据结构;

import java.util.Arrays;

/**
 * KMP算法
 * 字符串匹配
 */

public class KMP {
    //str文本串  dest 模式串
    public static boolean kmp(String str, String dest, int[] next) {

        int strBegin = 0;
        int index = 0; //已匹配的字符数
        int nos = 0;//　移动位数 = 已匹配的字符数 - 对应的部分匹配值
        while(strBegin < str.length()){
            char strChar = str.charAt(strBegin);
            //System.out.println("strBegin->"+strChar);
            char destChar = dest.charAt(index);
            //System.out.println("destChar->"+destChar);
            if(strChar == destChar){
                index++;
                if(index==dest.length()){
                    return true;
                }
                strBegin++;
            }
            if(strChar != destChar)
            {
                if(index > 0){
                    nos = index-next[index-1];
                    strBegin+=nos;
                }else {
                    strBegin++;
                }
                index = 0;
            }
        }
        return false;
    }

    public static int[] next(String dest) {
        int[] next = new int[dest.length()];
        for (int i = 1; i < dest.length() + 1; i++) {
            String index = dest.substring(0, i);
            String[] prefix = new String[index.length() - 1];
            String[] suffix = new String[index.length() - 1];
            if (index.length() < 2) {
                continue;
            } else {
                for (int j = 1; j < index.length(); j++) {
                    prefix[j - 1] = index.substring(0, j);
                }
                for (int j = index.length() - 1; j > 0; j--) {
                    suffix[j - 1] = index.substring(j, index.length());
                }
            }
            next[i - 1] = compare(prefix, suffix);
        }

        return next;
    }

    public static int compare(String[] prefix, String[] suffix) {
        //System.out.println("prefix->"+Arrays.toString(prefix));
        //System.out.println("suffix->"+Arrays.toString(suffix));
        int count = 0;
        for (int i = 0; i < prefix.length; i++) {
            for (int j = 0; j < suffix.length; j++) {
                if (prefix[i].equals(suffix[j])) {
                    count = prefix[i].length();
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //String str ="BBC ABCDAB ABCDABCDABDE" ;
        //String dest = "ABCDABD";
        String dest = "QWERQWR";
        String str = "WWE QWERQW QWERQWERQWRT";
        int[] next = next(dest);
        System.out.println(Arrays.toString(next));
        boolean b = kmp(str,dest,next);
        System.out.println(b);
    }

}
