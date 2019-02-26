package Tree;

public class _124 {
    static int res = Integer.MIN_VALUE;

    public int MaxPathSum(TreeNode root) {
        dp(root);
        return res;
    }

    public int dp(TreeNode root) {
        if (root != null) {
            int left = dp(root.left);
            int right = dp(root.right);
            res = max(res, max(0, left) + max(0, right) + root.val);
            return max(0, max(left, right)) + root.val;
        }
        return 0;
    }

    public int max(int a, int b) {
        if (a > b)
            return a;
        return b;
    }
}
