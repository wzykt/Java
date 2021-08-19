package leetCode.题目;

import java.util.Arrays;

public class _344 {
    public static void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }
        int right = s.length - 1;
        int left = 0;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

}
