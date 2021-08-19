package 蓝桥杯;

import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class _10 {

    public static void main(String[] args) {
        String s = "0100110001010001";
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length()+1; j++) {
                set.add(s.substring(i,j));
                list.add(s.substring(i,j));
            }
        }
        System.out.println(set.size());
        System.out.println(list.size());
    }
}
