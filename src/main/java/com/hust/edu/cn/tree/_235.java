package com.hust.edu.cn.tree;

class _235 {
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || p == null || q == null)
//            return null;
//        if (root == p || root == q)
//            return root;
//        TreeNode L = lowestCommonAncestor(root.left, p, q);
//        TreeNode R = lowestCommonAncestor(root.right, p, q);
//        return (L != null && R != null) ? root : (L != null) ? L : R;
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root.val <= q.val && root.val >= p.val || root.val >= q.val && root.val <= p.val) {
            return root;
        }
        if (root.val > q.val && root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);


    }
}
