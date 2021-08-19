package 数据结构;

import java.io.IOException;
import java.util.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class MyStack{

    public static void main(String[] args) throws ClassNotFoundException {
        Stack  stack = new Stack();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }


}
