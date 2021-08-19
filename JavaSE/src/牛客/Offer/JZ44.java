package 牛客.Offer;

/**
 * JZ44 翻转单词序列JZ44 翻转单词序列
 *
 * 2021/7/28
 *
 * 完成
 */
public class JZ44 {
    public static String ReverseSentence(String str) {
        if(str.isEmpty()){
            return "";
        }
        String[] strings = str.split(" ");
        int right = strings.length - 1;
        int left = 0;

        while (left < right) {
            String tem = strings[left];
            strings[left] = strings[right];
            strings[right] = tem;
            left++;
            right--;
        }
        String result = "";
        for (int i = 0; i < strings.length; i++) {
            result = result + strings[i] + " ";
        }

        result = result.substring(0,result.length()-2);
        return result;
    }

    public static void main(String[] args) {
        String s = "nowcoder. a am I";
        System.out.println(ReverseSentence(s));
    }
}
