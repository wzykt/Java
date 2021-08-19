package leetCode.树.二叉树;

/**
 * 二叉树结构如下定义:
 * Class Node {
 * V value;
 * Node left;
 * Node right;
 * Node parent;
 * }
 * 给你二叉树中的某个节点，返回该节点的后继节点(后继节点是指前序遍历过程中当前节点的下一个节点)
 * <p>
 * 2021/6/19
 */
public class Model1 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }


    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            // 无右子树
            Node parent = node.parent;
            while (parent != null && parent.right == node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }

    }

    public static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}