package DP;

public class _264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index1 = 0, index2 = 0, index3 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(2 * dp[index1], Math.min(3 * dp[index2], 5 * dp[index3]));
            if (dp[i] == 2 * dp[index1])
                index1++;
            if (dp[i] == 3 * dp[index2])
                index2++;
            if (dp[i] == 5 * dp[index3])
                index3++;
        }
        return dp[n - 1];
    }
}
