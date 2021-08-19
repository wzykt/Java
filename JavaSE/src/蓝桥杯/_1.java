package 蓝桥杯;


public class _1 {

    public static int sum(int level) {
        int i = 1;
        int sum = 0;
        while (i < level+1) {
            sum = sum + i;
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(100));
    }
}
