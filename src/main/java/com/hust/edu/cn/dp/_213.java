package com.hust.edu.cn.dp;

import org.junit.Test;

public class _213 {
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1, 3, 232, 32, 11, 0, 4, 9, 1};
        System.out.println(rob(nums));
    }

    /**
     * 两种选择：
     * 1.如果从第一个房间开始抢的话，最后房间一个必定不能抢，所以能抢的的位置为(0,1,2...n-2)
     * 2.如果从第二个房间开始抢的话，第一个房间必不能抢，能抢的位置为(1,2,3...n-1)
     * 比较第1种方案和第2种方案哪个收益最大
     *
     * @param nums
     * @return
     */
//    public int rob(int[] nums) {
//        int n = nums.length;
//        if (n == 0)
//            return 0;
//        if (n == 1)
//            return nums[0];
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//        if (n == 2)
//            return dp[1];
//        for (int i = 2; i < n - 1; i++)
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//        int max1 = dp[n - 2];
//        dp[1] = nums[1];
//        dp[2] = Math.max(nums[1], nums[2]);
//        for (int i = 3; i < n; i++)
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//        int max2 = dp[n - 1];
//        return Math.max(max1, max2);
//    }
    private int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int first, second;
        first = nums[0];
        second = Math.max(nums[0], nums[1]);
        if (n == 2) {
            return second;
        }
        for (int i = 2; i < n - 1; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        int max1 = second;
        first = nums[1];
        second = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        int max2 = second;
        return Math.max(max1, max2);
    }
}
