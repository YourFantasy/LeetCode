package com.hust.edu.cn.tree;

import java.util.Stack;

public class _783 {

    private long pre = Integer.MIN_VALUE, res = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return (int) res;
    }


    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            res = Math.min(res, root.val - pre);
            pre = root.val;
            inOrder(root.right);
        }
    }

    public int inOrder1(TreeNode root) {
        long pre = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                res = Math.min(res, p.val - pre);
                pre = p.val;
                p = p.right;
            }
        }
        return (int) res;
    }
}
