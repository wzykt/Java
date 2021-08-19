package 牛客.Offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * JZ62 二叉搜索树的第k个结点
 * <p>
 * 2021/8/5
 * <p>
 * 完成
 * 中序遍历即可
 */
public class JZ62 {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (k == 0 || pRoot == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        stack.push(pRoot);

        while (pRoot != null || stack.size() > 0) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            if (stack.size() > 0) {
                pRoot = stack.pop();
                list.add(pRoot);
                pRoot = pRoot.right;
            }
        }

        return list.get(k - 1);
    }
}
