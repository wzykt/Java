package 蓝桥杯;
/*
蓝桥杯第九届第二题
我们以某个小方格的一个顶点为圆心画一个半径为1000的圆。 你能计算出这个圆里有多少个完整的小方格吗？


解题思路：只看第一象限，圆心为（0，0），然后遍历第一象限圆内的所有点( i, j )，当且仅当这个点的左上角到圆心的距离小于半径，ans++。最后ans *= 4。
 */
public class _7 {

    public static void main(String[] args) {
        int count = 0;
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                if((int)Math.sqrt(x*x+y*y) <=1000){
                    count++;
                }
            }
        }
        System.out.println(count*4);
    }

}
