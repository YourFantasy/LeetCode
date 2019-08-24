package Tree;

public class _404 {
    int result = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        sum(root);
        return result;
    }

    public void sum(TreeNode root) {
        if (root != null) {
            if (root.left != null && root.left.left == null && root.left.right == null) {
                result += root.left.val;
            }
            sum(root.left);
            sum(root.right);
        }
    }
}
