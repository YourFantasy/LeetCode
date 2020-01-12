package com.hust.edu.cn.dp;

public class _376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = -1;
        int max1 = getMax(nums, len, dp);

        dp[0] = 1;
        int max2 = getMax(nums, len, dp);

        return Math.max(max1, max2);
    }

    public int getMax(int[] nums, int len, int[] dp) {
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = 1;
            } else if (nums[i] < nums[i - 1]) {
                dp[i] = -1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        int current = 1;
        int res = 1;
        for (int i = 1; i < len; i++) {
            if (dp[i] * dp[i - 1] == -1) {
                current += 1;
            }
            res = Math.max(res, current);
        }
        return res;
    }
}
