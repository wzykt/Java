package 蓝桥杯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class _9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        String[] a = (s1.split("\\s+"));
        String[] b = (s2.split("\\s+"));
        String[] c = (s3.split("\\s+"));
        System.out.println(Arrays.asList(a).toString() +":"+Arrays.asList(b).toString()+":"+Arrays.asList(c).toString());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(a[i]);
            B[i] = Integer.parseInt(b[i]);
            C[i] = Integer.parseInt(c[i]);
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < C.length; k++) {
                    if(A[i]<B[j]&&B[j]<C[k]){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
