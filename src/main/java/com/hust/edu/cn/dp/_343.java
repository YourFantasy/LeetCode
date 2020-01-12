package com.hust.edu.cn.dp;

import org.junit.Test;

public class _343 {
    @Test

    public void Test() {
        int n = 58;
        System.out.println(integerBreak(n));

    }

    private int integerBreak(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        if (n >= 2) {
            dp[2] = 1;
        }
        if (n >= 3) {
            dp[3] = 2;
        }
        if (n >= 4) {
            dp[4] = 4;
        }
        if (n >= 5) {
            dp[5] = 6;
        }
        if (n >= 6) {
            dp[6] = 9;
        }
        for (int i = 7; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
        }
        return dp[n];
    }
}
