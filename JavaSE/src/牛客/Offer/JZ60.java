package 牛客.Offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * JZ60 把二叉树打印成多行
 * <p>
 * 2021/8/5
 *
 * 参考答案，多加一个循环
 */
public class JZ60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(pRoot);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode tem = linkedList.poll();
                list.add(tem.val);
                if (tem.left != null) {
                    linkedList.add(tem.left);
                }
                if (tem.right != null) {
                    linkedList.add(tem.right);
                }
                size = size-1;
            }
            result.add(list);
        }
        return result;
    }
}
