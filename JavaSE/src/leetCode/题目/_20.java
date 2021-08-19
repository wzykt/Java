package leetCode.题目;

import java.util.Stack;

public class _20 {
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        char[] sarr = s.toCharArray();
        for (int i = 0; i < sarr.length; i++) {
            if(sarr[i]=='('||sarr[i]=='{'||sarr[i]=='[') stack.push(sarr[i]);
            if(stack.isEmpty()) return false;
            if(sarr[i]==')'&&'('!=stack.pop())return false;
            if(sarr[i]=='}'&&'{'!=stack.pop())return false;
            if(sarr[i]==']'&&'['!=stack.pop())return false;
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "()";
        //"([)]"  "]" "(])"
        boolean valid = isValid(s);

        System.out.println(valid);
    }
}
