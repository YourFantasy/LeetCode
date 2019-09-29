package Tree;

import static java.lang.Math.max;

class _124 {
    private static int res = Integer.MIN_VALUE;

    public int MaxPathSum(TreeNode root) {
        dp(root);
        return res;
    }

    private int dp(TreeNode root) {
        if (root != null) {
            int left = dp(root.left);
            int right = dp(root.right);
            res = max(res, max(0, left) + max(0, right) + root.val);
            return Math.max(0, max(left, right)) + root.val;
        }
        return 0;
    }

}
