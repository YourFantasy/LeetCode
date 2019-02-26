package Tree;

public class _226 {
    public TreeNode invertTree(TreeNode root) {
        inverse(root);
        return root;
    }

    public void inverse(TreeNode root) {
        if (root != null) {
            if (root.left != null || root.right != null) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
            invertTree(root.left);
            invertTree(root.right);
        }
    }
}
