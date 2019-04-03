package Tree;

public class _222 {
    public int countNodes(TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null)
                return 1;
            if (root.right == null)
                return 2;
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
        return 0;
    }
}
