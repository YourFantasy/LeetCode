package Tree;

import org.junit.Test;

public class _814 {
    @Test
    public void Test() {

    }

    public TreeNode pruneTree(TreeNode root) {
        if (root != null) {
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            if (root.val == 0 && root.left == null && root.right == null) {
                root = null;
            }
            return root;
        }
        return null;
    }
}
