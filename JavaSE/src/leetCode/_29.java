package leetCode;

/**
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数dividen除以除数divisor得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * Integer.MIN_VALUE和Integer.MAX_VALUE
 * <p>
 * 1.我们首先想到的是减法，能被减多少次，那么商就为多少，但是明显减法的效率太低
 * 2.
 */


public class _29 {

    //超时
    public static int divide(int dividend, int divisor) {
        long num = 0;
        if (dividend < 0 && divisor > 0) {
            while (dividend + divisor <= 0) {
                dividend = dividend + divisor;
                num--;
            }
        } else if (dividend > 0 && divisor > 0) {
            while (dividend - divisor >= 0) {
                dividend = dividend - divisor;
                num++;
            }
        } else if (dividend < 0 && divisor < 0) {
            while (dividend - divisor <= 0) {
                dividend = dividend +- divisor;
                num++;
            }
        } else if (dividend > 0 && divisor < 0) {
            while (dividend + divisor >= 0) {
                dividend = dividend + divisor;
                num--;
            }
        }
        if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)num;
    }

    public static void main(String[] args) {
        int divide = divide(-2147483648, -1);
        System.out.println(divide);
        int n = -1;
        System.out.println(1-n);
    }
}
