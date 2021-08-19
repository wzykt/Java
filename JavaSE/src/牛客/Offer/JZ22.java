package 牛客.Offer;

import java.util.ArrayList;

public class JZ22 {

    /**
     * @Author wzy
     * @param root
     * @return ArrayList
     * @Date 2021/7/20
     *
     */
    //队列的思想，保证left先于right
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();

        if(root == null){
            return list;
        }

        queue.add(root);
        while(queue.size()!=0){
            TreeNode node = queue.remove(0);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
            list.add(node.val);
        }
        return list;

    }

}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}