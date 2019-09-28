package Tree;

public class _104 {

    private int maxDepth(TreeNode root) {
        if (root != null) {
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            return (Math.max(l, r)) + 1;
        }
        return 0;
    }
}
