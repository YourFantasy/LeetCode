package com.hust.edu.cn.tree;

import java.util.*;

class _107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p;
        queue.offer(root);
        while (queue.size() > 0) {
            int len = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                p = queue.peek();
                queue.poll();
                temp.add(p.val);
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }

            }
            res.add(temp);


        }
        Collections.reverse(res);
        return res;

    }

}
