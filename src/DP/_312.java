package DP;

import org.junit.Test;

public class _312 {
    @Test
    public void test() {
        int n=10;
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=(int)(Math.random()*20);
            System.out.print(nums[i]+",");
        }
        System.out.println(maxCoins(nums));
    }

    private int maxCoins(int[] nums) {
        int n = nums.length;
        int[] digits = new int[n + 2];
        System.arraycopy(nums, 0, digits, 1, n);
        digits[0] = 1;
        digits[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + digits[k] * digits[i - 1] * digits[j + 1]);
                }
            }
        }
        return dp[1][n];
    }
}
