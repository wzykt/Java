package 牛客.Offer;

/**
 * JZ58 对称的二叉树
 * <p>
 * 2021/8/5
 *
 * 完成
 */
public class JZ58 {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        return isBalance(pRoot.left, pRoot.right);
    }

    public static boolean isBalance(TreeNode leftRoot, TreeNode rightRoot) {
        boolean result = false;
        if(leftRoot == null && rightRoot == null){
            return true;
        }

        if(leftRoot == null || rightRoot == null){
            return false;
        }
        if (leftRoot.val == rightRoot.val) {
            result = true;
        }

        result =  result && isBalance(leftRoot.left, rightRoot.right) && isBalance(leftRoot.right, rightRoot.left);
        return result;
    }
}
