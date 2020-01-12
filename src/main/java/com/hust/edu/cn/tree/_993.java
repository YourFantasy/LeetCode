package com.hust.edu.cn.tree;

import java.util.*;

/**
 * @author YourFantasy
 * @date 2019-08-23 14:07
 * @description: 判断二叉树中的两个节点是否是堂兄弟节点
 */
class _993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode p;
        while (!queue.isEmpty()) {
            int index = -1;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                p = queue.poll();
                if (p == null) {
                    continue;
                }
                if (p.val == x || p.val == y) {
                    if (index == -1) {
                        index = i;
                    } else {
                        return index % 2 == 1 || i - index > 1;
                    }
                }
                queue.offer(p.left);
                queue.offer(p.right);
            }
        }
        return false;
    }
}
