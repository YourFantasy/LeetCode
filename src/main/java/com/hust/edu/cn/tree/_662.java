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
                p = queue.poll();
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

    public int widthOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        TreeNode p;
        int index;
        q1.offer(root);
        q2.offer(1);
        int maxW = 1;
        while (!q1.isEmpty()) {
            int len = q1.size();
            int begin = q2.peek();
            for (int i = 0; i < len; i++) {
                p = q1.poll();
                index = q2.poll();
                if (i == len - 1) {
                    maxW = Math.max(maxW, index - begin + 1);
                }
                if (p.left != null) {
                    q1.offer(p.left);
                    q2.offer(index * 2);
                }
                if (p.right != null) {
                    q1.offer(p.right);
                    q2.offer(index * 2 + 1);
                }
            }
        }
        return maxW;
    }
}
