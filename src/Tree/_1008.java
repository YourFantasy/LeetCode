package Tree;

public class _1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode res = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            res=pre_order(res, preorder[i]);
        }
        return res;
    }

    TreeNode pre_order(TreeNode root, int val) {
        if (root != null) {
            if (root.val > val) {
                root.left = pre_order(root.left, val);
            } else {
                root.right = pre_order(root.right, val);
            }
        } else {
            root = new TreeNode(val);
        }
        return root;
    }

}
