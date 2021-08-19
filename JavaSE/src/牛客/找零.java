package 牛客;

import java.util.Scanner;

public class 找零 {

    public static int zhaoling(int n){
        int s = 1024-n;
        int num = 0;

        num = s /64+num;
        System.out.println(s /64);
        s = s %64;

        num = s /16 +num;
        System.out.println(s /16);
        s = s%16;

        num = num+ s /4;
        System.out.println(s /4);
        s = s%4;

        num = num+ s /1;
        System.out.println(s /1);
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int zhaoling = zhaoling(n);
        System.out.println(zhaoling);

    }

}
