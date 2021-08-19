package leetCode.树.二叉树;

/**
 * 给定一棵二叉树的头节点head，返回这颗二叉树是不是平衡二叉树
 *
 * 2021/6/25
 *
 * 二叉树递归套路解决
 */
public class AllTree {
    public static boolean isBalanced2(Node head) {
        return process2(head).isBalaced;
    }

    //左、右要求一样，Info信息返回的结构体
    public static class Info {
        public boolean isBalaced;
        public int height;

        public Info(boolean b, int h) {
            isBalaced = b;
            height = h;
        }
    }

    public static Info process2(Node x) {
        if (x == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process2(x.left);
        Info rightInfo = process2(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = true;
        if (!leftInfo.isBalaced || !rightInfo.isBalaced || Math.abs(leftInfo.height - rightInfo.height) > 0) {
            isBalanced = false;
        }
        return new Info(isBalanced, height);
    }

}


class Node {

    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        super();
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " ";
    }

}
