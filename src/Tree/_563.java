package Tree;

class _563 {
    private int sum = 0;

    public int findTilt(TreeNode root) {
        FindTilt(root);
        return sum;
    }

    private void FindTilt(TreeNode root) {
        if (root != null) {
            sum += Math.abs(inorder(root.left) - inorder(root.right));
            FindTilt(root.left);
            FindTilt(root.right);
        }
    }

    private int inorder(TreeNode node) {
        int Sum = 0;
        if (node != null) {
            Sum += node.val;
            Sum += inorder(node.left);
            Sum += inorder(node.right);
            return Sum;
        }
        return 0;
    }
}
