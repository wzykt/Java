package 蓝桥杯;

import java.util.*;

public class _6 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < 2500; i++) {
            for (int j = 0; j < 2500; j++) {
                for (int k = 0; k < 2500; k++) {
                    for (int l = 0; l < 2500; l++) {
                        if (i * i + j * j + k * k + l * l == n && i <= j && j <= k && k <= l) {
                            System.out.println(i + " " + j + " " + k + " " + l);
                            return;
                        }
                    }
                }
            }
        }

    }
}