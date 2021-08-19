package 牛客.Offer;

import 牛客.TreeNode;

/**
 * 树的子结构
 * <p>
 * 2021/7/1
 * <p>
 * 未完成
 */
public class JZ17 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }
        return isTrue(A, B);
    }

    public static boolean isTrue(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        Info process = process(root1, root2);
        if (process.isEqual) {
            return true;
        }
        //重点就是这一步
        return isTrue(root1.left, root2)||isTrue(root1.right, root2);
    }


    public static class Info {
        boolean isEqual;

        public Info(boolean isEqual) {
            this.isEqual = isEqual;
        }
    }


    public static Info process(TreeNode root1, TreeNode root2) {
        if (root2 != null) {
            if (root1 == null) {
                return new Info(false);
            }
        }
        if(root2 == null){
            return new Info(true);
        }


        Info leftInfo = process(root1.left, root2.left);
        Info rightInfo = process(root1.right, root2.right);

        if (leftInfo.isEqual && rightInfo.isEqual && root1.val == root2.val) {
            return new Info(true);
        } else {
            return new Info(false);
        }
    }
}
