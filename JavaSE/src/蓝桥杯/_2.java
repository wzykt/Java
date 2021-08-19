package 蓝桥杯;

/*
生日蜡烛

某君从某年开始每年都举办一次生日party，并且每次都要吹熄与年龄相同根数的蜡烛。

现在算起来，他一共吹熄了236根蜡烛。

请问，他从多少岁开始过生日party的？
 */

public class _2 {

    public static int test(int index) {
        int age = 10;
        int i = age;
        int c = 0;
        int count = i;
        while ((index - count) != 0) {
            if (count > index) {
                count = 0;
                c++;
                i = 10 + c;
                count = count + i;
                continue;
            }
            i++;
            count = count + i;
        }
        return age + c;
    }

    public static void main(String[] args) {
        System.out.println(test(236));
    }

}
