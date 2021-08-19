package 牛客.Offer;

import java.util.Arrays;

/**
 * JZ4 重建二叉树
 * <p>
 * 2021/8/3
 *
 * 参考答案，思路正确，无法用语言实现
 */
public class JZ4 {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        // 在中序中找到前序的根
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                //copyOfRange(int []original,int from,int to),
                // original为原始的int型数组，from为开始角标值，to为终止角标值。（其中包括from角标，不包括to角标。即处于[from,to)状态）

                // 左子树，注意 copyOfRange 函数，左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                // 右子树，注意 copyOfRange 函数，左闭右开
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in,
                        i + 1, in.length));
                break;
            }
        }
        return root;
    }
}
