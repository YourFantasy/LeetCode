package Tree;

public class _543 {
    int maxlen = 0;

    public int diameterOfBinary(TreeNode root) {
        if (root != null) {
            int left = diameterOfBinary(root.left);
            int right = diameterOfBinary(root.right);
            maxlen = Math.max(maxlen, left + right);
            return 1 + Math.max(left, right);
        }
        return 0;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinary(root);
        return maxlen;
    }
}
