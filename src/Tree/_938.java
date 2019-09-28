package Tree;

class _938 {
    private int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if (root != null) {
            if (root.val >= L && root.val <= R) {
                sum += root.val;
            }
            sum += rangeSumBST(root.left, L, R);
            sum += rangeSumBST(root.right, L, R);
            return sum;
        }
        return 0;
    }
}
