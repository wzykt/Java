package leetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _1006 {


    public static int clumsy(int N) {
        //栈的思想
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(N);
        N--;

        int index = 0; // 用于控制乘、除、加、减
        while (N > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {
                stack.push(N);
            } else {
                stack.push(-N);
            }
            index++;
            N--;
        }

        // 把栈中所有的数字依次弹出求和
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    /*
    //自己错误的理解
    public static int clumsy(int N) {
        int num = 0;

        String str[] = {"*", "/", "+", "-"};
        String[] target = new String[N * 2 - 1];
        int begin = 0;
        int index = 0;
        //StringBuffer target = new StringBuffer();
        for (int i = N; i > 0; i--) {
            target[begin] = i + "";
            begin++;
            if (begin == target.length) {
                break;
            }
            target[begin] = (str[index]);
            index++;
            begin++;
            if (index > 3) {
                index = 0;
            }
        }
        System.out.println(Arrays.toString(target));
        num = N;
        for (int i = 1; i < target.length-1; i++) {
            switch (target[i]) {
                case "*":{
                    i++;
                    num = num * Integer.parseInt(target[i]);
                    System.out.println(num);
                    break;
                }
                case "/":{
                    i++;
                    num = num / Integer.parseInt(target[i]);
                    System.out.println(num);
                    break;
                }
                case "+":{
                    i++;
                    num = num + Integer.parseInt(target[i]);
                    System.out.println(num);
                    break;
                }
                case "-":{
                    i++;
                    num = num - Integer.parseInt(target[i]);
                    System.out.println(num);
                    break;
                }
            }
        }
        return num;
    }*/

    public static void main(String[] args) {
        System.out.println(clumsy(10));
        //System.out.println(10/3);
    }

}
