package com.hust.edu.cn.dp;

public class _650 {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    int k = i / j;
                    if (k >= 2) {
                        dp[i] = Math.min(dp[i], Math.min(k + dp[j], j + dp[k]));
                    } else {
                        dp[i] = Math.min(dp[i], Math.min(2 * k - 1 + dp[j], j + dp[k]));
                    }
                }
            }
        }
        return dp[n];
    }
}
