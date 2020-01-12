package com.hust.edu.cn.dp;

public class _53 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            max = Math.max(max, dp[i]);
        }


        return max;
    }

    public int maxSubArray1(int[] nums) {
        int pre = nums[0];
        int max = pre;
        for (int i = 1; i < nums.length; i++) {
            if (pre > 0) {
                pre += nums[i];
            } else {
                pre = nums[i];
            }

            max = Math.max(max, pre);
        }
        return max;
    }
}
