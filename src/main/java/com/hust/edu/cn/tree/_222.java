package com.hust.edu.cn.tree;

class _222 {
    private int countNodes(TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                return 1;
            }
            if (root.right == null) {
                return 2;
            }
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
        return 0;
    }
}
