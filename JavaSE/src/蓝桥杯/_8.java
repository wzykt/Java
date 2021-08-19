package 蓝桥杯;
/*
第九届蓝桥杯第三题

 */
public class _8 {


    public static String test() {
        int i = 1;
        int a = 2;
        int b = 3;
        int before =0;
        int after =0;
        while (i < 123456) {
            before = 2 * a - 3 * b;
            after = b * 2 + a * 3;
            a = before;
            b = after;
            i++;
        }
        return a + "+" + b + "i";
    }

    public static void main(String[] args) {
        String test = test();
        System.out.println(test);
    }

}
