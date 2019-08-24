package Tree;

public class _530 {
//    private int min = Integer.MAX_VALUE;
//    private TreeNode pre = null;
//
//    public int getMinimumDifference(TreeNode root) {
//        inorder(root);
//        return min;
//    }
//
//    public void inorder(TreeNode root) {
//        if (root != null) {
//            inorder(root.left);
//            if (pre != null)
//                min = Math.min(min, root.val - pre.val);
//            pre = root;
//            inorder(root.right);
//        }
//    }

    private int min = Integer.MAX_VALUE;
    private int pre = -1;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            if (pre >= 0) {
                min = Math.min(min, root.val - pre);
            }
            pre = root.val;
            inorder(root.right);
        }
    }
}
