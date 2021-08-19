package 牛客.Offer;

/**
 * 2021/8/1
 *
 * 借助答案完成,不知道trim()方法，空格的处理出现问题
 *
 * 分析
 * 首部空格： 删除之即可；
 * 符号位： 三种情况，即 ''++'' , ''-−'' , ''无符号" ；新建一个变量保存符号位，返回前判断正负即可。
 * 非数字字符： 遇到首个非数字的字符时，应立即返回。
 * 数字字符：
 * 字符转数字： “此数字的 ASCII 码” 与 “ 00 的 ASCII 码” 相减即可；
 * 数字拼接： 若从左向右遍历数字，设当前位字符为 cc ，当前位数字为 xx ，数字结果为 res ，则数字拼接公式为：
 */
public class JZ49 {
    public static int strToInt(String str) {
        //trim() 方法用于删除字符串的头尾空白符，空白符包括：空格、制表符tab、换行符等其他空白符等。
        char[] c = str.trim().toCharArray();
        if(c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if(c[0] == '-') sign = -1;
        else if(c[0] != '+') i = 0;
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;
            if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }

    public static void main(String[] args) {
        String s = " ";
        System.out.println(strToInt(s));
    }

}
