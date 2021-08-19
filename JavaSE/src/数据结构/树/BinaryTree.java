package 数据结构.树;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        super();
        this.data = data;
    }

    @Override
    public String toString() {
        return data + " ";
    }

}

public class BinaryTree {

    public TreeNode root = null;

    public BinaryTree(int[] array, int index) {
        root = createBinaryTree(array, index);
    }
    // 创建二叉树

    private TreeNode createBinaryTree(int[] array, int index) {

        TreeNode treeNode = null;
        if (index < array.length) {
            treeNode = new TreeNode(array[index]);
            // 对于顺序存储的完全二叉树，如果某个节点的索引为index，其对应的左子树的索引为2*index+1，右子树为2*index+1
            treeNode.left = createBinaryTree(array, 2 * index + 1);
            treeNode.right = createBinaryTree(array, 2 * index + 2);
        }
        return treeNode;

    }

    private void showData(TreeNode node) {
        System.out.print(node);
    }

    // 递归遍历二叉树

    // 先序遍历（前序遍历）
    public void preOrder(TreeNode node) {
        if (node != null) {
            showData(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 中序遍历
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            showData(node);
            inOrder(node.right);
        }
    }
    // 后序遍历

    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            showData(node);
        }
    }

    // 非递归遍历二叉树

    // 前序遍历

    public void noRecursionPreOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        if (node != null) {
            stack.push(node);
            while (!stack.empty()) {
                node = stack.pop();
                showData(node);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }

            }
        }
    }

    // 中序遍历
    public void noRecursionInOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = node;
        while (p != null || stack.size() > 0) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (stack.size() > 0) {
                p = stack.pop();
                showData(p);
                p = p.right;
            }
        }
    }

    //后序遍历 ,需要记录遍历过的节点
    public void noRecursionPostOrder(TreeNode node) {
        TreeNode pre = node;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null) {
            for (; node.left != null; node = node.left) {
                stack.push(node);
            }
            while (node != null && (node.right == null || node.right == pre)) {
                showData(node);
                pre = node;
                if (stack.empty()) return;
                node = stack.pop();
            }
            stack.push(node);
            node = node.right;
        }
    }

    /*
    非递归方式先序遍历，栈实现

        1. 弹出就打印
        2. 如果有右节点，压入右节点
        3. 如果有左节点，压入左节点
     */
    public static void pre(TreeNode head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.data + "");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /*
    非递归方式后序遍历，栈实现

        1. 弹出就打印
        2. 如果有左节点，压入左节点
        3. 如果有右节点，压入右节点

    此方法打印的是后序遍历的逆序方式
    public static void pos1(TreeNode head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.data + "");
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
        }
        System.out.println();
    }
    */
    public static void pos1(TreeNode head) {
        System.out.print("pos-order: ");
        if (head != null) {
            //使用第二个栈存储逆序的后序遍历结果
            Stack<TreeNode> s1 = new Stack<TreeNode>();
            Stack<TreeNode> s2 = new Stack<TreeNode>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().data + "");
            }
        }
        System.out.println();
    }

    /*
       非递归方式中序遍历，栈实现

       1.当前节点左边界依次入栈（）包括当前节点
       2. 第一步无法继续，弹出当前节点，进入右节点，再次执行第一步

     */
    public static void in(TreeNode head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.data + "");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }


    //层次遍历
    public static void level(TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.data);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


    //二叉树序列化

    public static Queue<String> levelSerial(TreeNode head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.data));
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(head);
            while (!queue.isEmpty()) {
                head = queue.poll();
                if (head.left != null) {
                    ans.add(String.valueOf(head.left.data));
                    queue.add(head.left);
                } else {
                    ans.add(null);
                }
                if (head.right != null) {
                    ans.add(String.valueOf(head.right.data));
                    queue.add(head.right);
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //顺序存储的满二叉树或者完全二叉树
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinaryTree bt = new BinaryTree(arr, 0);
        System.out.println("递归前序遍历：");
        bt.preOrder(bt.root);
        System.out.println();
        System.out.println("递归中序遍历：");
        bt.inOrder(bt.root);
        System.out.println();
        System.out.println("递归后序遍历：");
        bt.postOrder(bt.root);
        System.out.println();
        System.out.println("非递归前序遍历：");
        bt.noRecursionPreOrder(bt.root);
        System.out.println();
        System.out.println("非递归中序遍历：");
        bt.noRecursionInOrder(bt.root);
        System.out.println();
        System.out.println("非递归后序遍历：");
        bt.noRecursionPostOrder(bt.root);

    }

}