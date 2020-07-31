package com.hust.edu.cn.tree;

import java.util.HashSet;
import java.util.Set;

public class _1261 {
    class FindElements {
        Set<Integer> nodes;

        public FindElements(TreeNode root) {
            root.val = 0;
            this.nodes = new HashSet<>();
            buildTree(root, this.nodes);
            buildTree(root, 0, this.nodes);
        }

        private void buildTree(TreeNode root, Set<Integer> nodes) {
            if (root != null) {
                nodes.add(root.val);
                if (root.left != null) {
                    root.left.val = 2 * root.val + 1;
                }
                if (root.right != null) {
                    root.right.val = 2 * root.val + 2;
                }
                buildTree(root.left, nodes);
                buildTree(root.right, nodes);
            }
        }

        private void buildTree(TreeNode root, int val, Set<Integer> nodes) {
            if (root != null) {
                root.val = val;
                nodes.add(val);
                buildTree(root.left, 2 * val + 1, nodes);
                buildTree(root.right, 2 * val + 2, nodes);
            }
        }

        public boolean find(int target) {
            if (target < 1) {
                return false;
            }
            return nodes.contains(target);
        }
    }
}
