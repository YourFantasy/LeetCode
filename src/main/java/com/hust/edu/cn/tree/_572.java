package com.hust.edu.cn.tree;

class _572 {
    private boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s != null && t != null) {
            return preorder(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        return false;
    }

    private boolean preorder(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s != null && t != null && s.val == t.val) {
            return preorder(s.left, t.left) && preorder(s.right, t.right);
        }
        return false;
    }
}
