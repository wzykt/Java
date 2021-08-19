package 蓝桥杯;

import java.util.*;

public class _5 {

    public static int test(String tar) {
        int S = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < tar.length(); i++) {
            for (int j = i + 1; j <= tar.length(); j++) {
                list.add(tar.substring(i, j));
            }
        }
        System.out.println(list.toString());
        int bucket[] = new int[26];
        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < 26; i++) {
//            map.put((char)('a' + i) + "", 0);
//        }
//        System.out.println(map.toString());

        for (int i = 0; i < list.size(); i++) {
            String index = list.get(i);
            int count = 0;
            for (int j = 0; j < index.length(); j++) {
                if (map.containsKey(index.substring(j,j+1))) {
                    int s = map.get(index.substring(j,j+1))+1;
                    map.put(index.substring(j,j+1),s);
                }else{
                    map.put(index.substring(j,j+1),1);
                    count = 0;
                }
            }
            System.out.println(map.toString());
            for (String key : map.keySet()) {
                if (map.get(key).equals(1)) {
                    S++;
                }
            }
            map.clear();
        }
        return S;
    }

    public static void main(String[] args) {
        String tar = "ababc";
        String tar1 = "aba";
        int S = test(tar1);
        System.out.println(S);
    }

}
