package com.hust.edu.cn.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _1339 {
    private long mod = 1000000007;
    private long total = 0;
    private long res = 0;
    private long sub = 0;

    public int maxProduct1(TreeNode root) {
        long result = 0;
        List<Long> sumList = new ArrayList<>();
        long total = getNodeSum(root, sumList);
        for (long sum : sumList) {
            long multi = sum * (total - sum);
            result = Math.max(result, multi);
        }
        return (int) (result % mod);
    }

    public int maxProduct2(TreeNode root) {
        total = sum(root);
        sum(root);
        return (int) (res % mod);
    }

    private long sum(TreeNode root) {
        if (root != null) {
            sub = root.val + sum(root.left) + sum(root.right);
            res = Math.max(res, sub * (total - sub));
            return sub;
        }
        return 0;
    }

    private long getNodeSum(TreeNode root, List<Long> res) {
        long s = 0;
        if (root != null) {
            s += root.val;
            s += getNodeSum(root.left, res);
            s += getNodeSum(root.right, res);
            if (s > 0) {
                res.add(s);
            }
            return s;
        }
        return s;
    }
}


class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
