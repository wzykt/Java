package 牛客.Offer;

import java.util.*;

/**
 * JZ27 字符串的排列
 *
 * 2021/7/25
 *
 * 借鉴答案完成
 */
public class JZ27 {

    /*
    总结：回溯涉及对象状态的恢复

    操作对象可以提升作用域，作为成员变量，而不仅仅局限于方法参数，或局部变量
     */
    ArrayList<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public ArrayList<String> Permutation(String str) {
        char[] c = str.toCharArray();
        boolean[] used = new boolean[c.length];
        backTracking(c,used);
        return res;
    }
    void backTracking(char[] c,boolean[] used){
        if(path.length()==c.length){
            if(!res.contains(path.toString())){//a，a情况会出现[aa,aa]
                res.add(path.toString());
            }
            return;
        }
        for(int i=0;i<c.length;i++){
            if(used[i]==true) continue;
            used[i] = true;
            path.append(c[i]);
            backTracking(c,used);

            //状态的回溯
            path.deleteCharAt(path.length()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        JZ27 test = new JZ27();
        ArrayList<String> permutation = test.Permutation(s);
        System.out.println(permutation.toString());
    }

}
