package com.hust.edu.cn.dp;

public class _1262 {
    public int maxSumDivThree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp0 = 0, dp1 = 0, dp2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = dp0;
            if (nums[i] % 3 == 0) {
                dp0 += nums[i];
                dp1 += nums[i];
                dp2 += nums[i];
            } else if (nums[i] % 3 == 1) {
                if ((dp2 + nums[i]) % 3 == 0) {
                    dp0 = Math.max(dp0, dp2 + nums[i]);
                }

                if ((dp1 + nums[i]) % 3 == 2) {
                    dp2 = Math.max(dp2, dp1 + nums[i]);
                }

                if ((t + nums[i]) % 3 == 1) {
                    dp1 = Math.max(dp1, t + nums[i]);
                }

            } else {

                if ((dp1 + nums[i]) % 3 == 0) {
                    dp0 = Math.max(dp0, dp1 + nums[i]);
                }
                if ((dp2 + nums[i]) % 3 == 1) {
                    dp1 = Math.max(dp1, dp2 + nums[i]);
                }
                if ((t + nums[i]) % 3 == 2) {
                    dp2 = Math.max(dp2, t + nums[i]);
                }
            }
        }
        return dp0;
    }
}
