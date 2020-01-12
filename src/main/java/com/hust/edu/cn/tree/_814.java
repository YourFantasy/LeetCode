package com.hust.edu.cn.tree;

public class _814 {

    private TreeNode pruneTree(TreeNode root) {
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
