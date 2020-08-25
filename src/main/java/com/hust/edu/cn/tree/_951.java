package com.hust.edu.cn.tree;

public class _951 {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // 都为空，true
        if (root1 == null && root2 == null) {
            return true;
        }
        // 一个为空，一个不为空，false
        if (root1 == null || root2 == null) {
            return false;
        }
        // 相等
        if (root1.val == root2.val) {

            // flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) 不用翻转
            // flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right) 翻转
            // 两种情况有一种符合，就表示翻转等价
            return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) || flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right);
        }
        // root1.val!=root2.val,返回false
        return false;
    }
}
