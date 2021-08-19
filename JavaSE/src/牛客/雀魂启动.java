package 牛客;

import java.util.*;

public class 雀魂启动 {

    public static List<Integer> check(int[] temp){
        int[] after = {4,4,4,4,4,4,4,4,4};
        for (int i = 0; i < temp.length; i++) {
            after[temp[i]-1]--;
        }
        System.out.println(Arrays.toString(after));
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] tar = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            tar[i] = Integer.parseInt(s[i]);
        }
        List<Integer> check = check(tar);
        System.out.println(check.toString());
    }

}
