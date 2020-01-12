package com.hust.edu.cn.tree;

import java.util.*;

class _103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int k = 0;
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode p = queue.poll();
                temp.add(p.val);
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            if (k % 2 == 1) {
                Collections.reverse(temp);
            }
            if (!temp.isEmpty()) {
                res.add(temp);
            }
            k++;
        }
        return res;
    }
}
