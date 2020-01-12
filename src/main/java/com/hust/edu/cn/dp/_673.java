package com.hust.edu.cn.dp;

import org.junit.Test;

import java.util.Arrays;

public class _673 {
    @Test
    public void test(){
        int[] nums={1,3,7,5,4};
        findNumberOfLIS(nums);
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        int[] count = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    } else if (dp[j] + 1 > dp[i]) {
                        count[i] = count[j];
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(count));
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == maxLen) {
                res += count[i];
            }
        }
        return res;
    }


}
