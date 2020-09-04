package com.hust.edu.cn.tree;

public class _108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int m = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, left, m - 1);
        root.right = buildTree(nums, m + 1, right);
        return root;
    }
}
