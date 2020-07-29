package com.hust.edu.cn.tree;

public class _979 {
    /**
     * 后序遍历，以当前节点为父节点，当前节点以及子节点全部变为1还富余多少(或者缺少)，富余（或者缺少）的硬币转移或者从父节点的父节点哪转移或者要，记录这个过程中的移动次数,times+=Math.abs(left)+Math.right(right);
     *
     * @param root
     * @return
     */

    public int distributeCoins(TreeNode root) {
        needMove(root);
        return times;
    }

    int times = 0;

    public int needMove(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = needMove(root.left);
        int right = needMove(root.right);
        int total = left + right + root.val - 1;
        times += Math.abs(left) + Math.abs(right);
        return total;
    }
}
