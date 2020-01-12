package com.hust.edu.cn.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _662 {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        TreeNode p;
        queue.offer(root);
        map.put(root, 1);
        while (queue.size() > 0) {
            int left = 0, right = 0;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                p = queue.peek();
                queue.poll();
                if (i == 0) {
                    left = map.get(p);
                }
                if (i == len - 1) {
                    right = map.get(p);
                }
                if (p.left != null) {
                    queue.offer(p.left);
                    map.put(p.left, 2 * map.get(p));
                }
                if (p.right != null) {
                    queue.offer(p.right);
                    map.put(p.right, 2 * map.get(p) + 1);
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
