package leetCode;

/*寻找比目标字母大的最小字母
给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。在比较时，字母是依序循环出现的。举个例子：

如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'



 */
public class L_744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;//关键
            if (letters[m] <= target) {
                l = m + 1;//关键
            } else {
                h = m - 1;//关键
            }
        }
        return l < n ? letters[l] : letters[0];
    }

    public static void main(String[] args) {
        L_744 l = new L_744();
        char letters[] = {'c', 'f', 'j'};
        System.out.println(l.nextGreatestLetter(letters, 'g'));
    }

}
