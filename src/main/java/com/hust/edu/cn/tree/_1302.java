package com.hust.edu.cn.tree;

import java.util.LinkedList;
import java.util.Queue;

public class _1302 {
    public int deepestLeavesSum1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode p;
        while (!queue.isEmpty()) {
            int len = queue.size();
            boolean flag = true;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                p = queue.poll();
                if (p.left == null && p.right == null) {
                    sum += p.val;
                    continue;
                }
                flag = false;
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            if (flag) {
                return sum;
            }
        }
        return 0;
    }


    public int deepestLeavesSum2(TreeNode root) {
        preOrder(root, 0);
        return sum;
    }

    private int maxLevel = 0, sum = 0;

    public void preOrder(TreeNode root, int level) {
        if (root != null) {
            if (level > maxLevel) {
                maxLevel = level;
                sum = root.val;
            } else if (level == maxLevel) {
                sum += root.val;
            }
            preOrder(root.left, level + 1);
            preOrder(root.right, level + 1);
        }

    }
}
