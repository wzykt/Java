package leetCode.树.二叉树;

/**
 * 给定一棵二叉树的头节点head,
 * 返回这颗二叉树中最大的二叉搜索子树的头节点
 *
 * 2021/6/25
 *
 * 二叉树的递归套路
 */
public class MaxSubBSTSize {
    public static int maxSubBSTSize2(Node head) {
        if (head == null) {
            return 0;
        }
        return process(head).maxSubBSTSize;
    }

    //任何子树
    public static class Info {
        public boolean isAllBST;
        public int maxSubBSTSize;
        public int min;
        public int max;

        public Info(boolean is, int size, int mi, int ma) {
            isAllBST = is;
            maxSubBSTSize = size;
            min = mi;
            max = ma;
        }
    }

    public static Info process(Node x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int min = x.value;
        int max = x.value;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        boolean isAllBST = false;
        int maxSubBSTSize = 0;
        if (leftInfo != null) {
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }
        if (rightInfo != null) {
            maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
        }

        if (
            //左树整体需要是搜索二叉树
                (leftInfo == null ? true : leftInfo.isAllBST && (rightInfo == null ? true : rightInfo.isAllBST) &&
                        //左树最大值<x
                        (leftInfo == null ? true : leftInfo.max < x.value) &&
                        (rightInfo == null ? true : rightInfo.min > x.value)
                )
        ) {
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize) + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
            isAllBST = true;
        }
        return new Info(isAllBST, maxSubBSTSize, min, max);
    }
}