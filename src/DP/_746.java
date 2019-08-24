package DP;

public class _746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= n; i++) {
            if (i < n) {
                dp[i] = cost[i] + Math.min(dp[i - 2], dp[i - 1]);
            } else {
                dp[i] = Math.min(dp[i - 2], dp[i - 1]);
            }
        }
        return dp[n];
    }
}
