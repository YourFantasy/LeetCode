package com.hust.edu.cn.tree;

class _129 {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode root, int data) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return (root.val + 10 * data);
        }
        return sum(root.left, root.val + 10 * data) + sum(root.right, root.val + 10 * data);

    }
}
