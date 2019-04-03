package Tree;

import com.sun.source.tree.Tree;

public class _106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;
        TreeNode res = new TreeNode(0);
        createTree(res, inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return res;
    }

    TreeNode createTree(TreeNode root, int[] inorder, int begin1, int end1, int[] postorder, int begin2, int end2) {
        if (begin1 <= end1) {
            root.val = postorder[end2];
            int index = get_index(postorder[end2], begin1, end1, inorder);
            int len_left = index - begin1;
            int len_right = end1 - index;
            TreeNode left = new TreeNode(0);
            TreeNode right = new TreeNode(0);
            if (len_left > 0)
                root.left = createTree(left, inorder, begin1, index - 1, postorder, begin2, begin2 + len_left - 1);

            if (len_right > 0)
                root.right = createTree(right, inorder, index + 1, end1, postorder, end2 - len_right, end2 - 1);
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
