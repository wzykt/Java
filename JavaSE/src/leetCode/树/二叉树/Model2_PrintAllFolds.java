package leetCode.树.二叉树;

/**
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开。此时折痕是凹下去的，即折痕突起的万向指向纸条的首连。如果A纸条的下边向上方连续对折2次，压出折痕后展开，此时有二余折很，从上到下依次是下折痕、下折痕和上折痕。
 * 给定一个输入参数N，代表纸条都从下边向上方连续对折N次。请从上到下打印所有折痕的方向。
 * 例如:N=1时，打印: down N=2时，打印: down down up
 *
 */
public class Model2_PrintAllFolds {
    public static void printAl1Folds(int N) {
        printProcess(1, N, true);
    }

    //递归过程，来到了某一个节点，
    //i是节点的层数，N一共的层数，down == true叫down == false凸
    public static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 3;
        printAl1Folds(N);
    }
}