package Tree;

public class _110 {
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return flag;
    }
    //在求树的高度的时候顺便判断是否为平衡二叉树
    int depth(TreeNode root) {
        if (root != null) {
            int left = depth(root.left);
            int right = depth(root.right);
            if (flag) {
                if (Math.abs(left - right) > 1) {
                    flag = false;
                }
            }
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
