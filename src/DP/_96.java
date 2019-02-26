package DP;

import org.junit.Test;

public class _96 {
    @Test
    public void Test() {

    }

    public int numTrees(int n) {
        if (n < 2)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int k = 1; k <= i; k++)
                dp[i] += dp[k - 1] * dp[i - k];

        return dp[n];
    }
}
