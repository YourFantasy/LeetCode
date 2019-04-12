package DP;

import java.util.Arrays;

public class _300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return len;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i])
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }
}
