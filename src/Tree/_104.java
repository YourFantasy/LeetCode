package Tree;

import org.junit.Test;

public class _104 {
    @Test
    public void Test() {

    }

    public int maxDepth(TreeNode root) {
        if (root != null) {
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            return (l > r ? l : r) + 1;
        }
        return 0;
    }
}
