package 牛客.Offer;

/**
 * JZ57
 * <p>
 * 2021/8/3
 * <p>
 * /8/3未完成
 * 没有思路
 *
 * /8/4完成
 * 如果当前节点的右节点存在左子树，则后继节点就是右节点的最左的节点，否则就是当前右节点
 * 如果当前节点不存在右子树，则向上寻找，且当前节点不是父节点的左子树
 */
public class JZ57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        if (pNode.right != null) {
            return getFastNode(pNode.right);
        }else {
            TreeLinkNode parent = pNode.next;

            while(parent!=null && pNode != parent.left){
                pNode = parent;
                parent = pNode.next;
            }
            return parent;
        }
    }

    public static TreeLinkNode  getFastNode(TreeLinkNode node){
        if(node == null){
            return node;
        }

        while(node.left !=null){
            node = node.left;
        }
        return node;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}