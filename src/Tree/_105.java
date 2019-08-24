package Tree;

public class _105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        TreeNode res = new TreeNode(0);
        create_Tree(res, preorder, 0, preorder.length - 1, 0, inorder.length - 1, inorder);
        return res;
    }

    TreeNode create_Tree(TreeNode root, int[] preorder, int begin1, int end1, int begin2, int end2, int[] inorder) {
        if (begin2 <= end2) {
            int index = get_index(preorder[begin1], begin2, end2, inorder);
            root.val = preorder[begin1];
            TreeNode left = new TreeNode(0);
            TreeNode right = new TreeNode(0);
            int cnt_left = index - begin2;
            int cnt_right = end2 - index;
            if (cnt_left > 0) {
                root.left = create_Tree(left, preorder, begin1 + 1, cnt_left + begin1, begin2, index - 1, inorder);
            }
            if (cnt_right > 0) {
                root.right = create_Tree(right, preorder, end1 + 1 - cnt_right, end1, index + 1, end2, inorder);
            }
            return root;
        }
        return null;
    }

    private int get_index(int a, int i, int j, int[] inorder) {
        int index = i;
        for (int k = i; k <= j; k++) {
            if (a == inorder[k]) {
                index = k;
                break;
            }
        }
        return index;
    }
}
