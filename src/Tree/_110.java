package Tree;

public class _110 {
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return flag;
    }

    int depth(TreeNode root) {
        if (root != null) {
            int left = depth(root.left);
            int right = depth(root.right);
            if (flag) {
                if (Math.abs(left - right) > 1)
                    flag = false;
            }
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
