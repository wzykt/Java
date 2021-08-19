package 牛客.Offer;

import 牛客.TreeNode;

import java.util.LinkedList;

/**
 * 平衡二叉树
 *
 * 2021/7/1
 *
 * 完成
 */
public class JZ39 {

    public static class Info{
        boolean isBalance;
        int HDif;
        public Info(boolean isBalance,int HDif){
            this.HDif = HDif;
            this.isBalance = isBalance;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return process(root).isBalance;

    }

    public Info process(TreeNode node){
        if (node == null){
            return new Info(true,0);
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        if(leftInfo.isBalance && rightInfo.isBalance && Math.abs(leftInfo.HDif- rightInfo.HDif) < 2){
            return new Info(true,Math.max(leftInfo.HDif, rightInfo.HDif)+1);
        }else{
            return new Info(false,Math.max(leftInfo.HDif, rightInfo.HDif)+1);
        }
    }
}
