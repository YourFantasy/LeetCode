package com.hust.edu.cn.greedy;

public class _1144 {
    public int movesToMakeZigzag(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i == 0 ? Integer.MAX_VALUE : nums[i - 1];
            int right = i == nums.length - 1 ? Integer.MAX_VALUE : nums[i + 1];
            if (i % 2 == 0) {
                // 偶数位比左右两边都小方案
                if (nums[i] >= Math.min(left, right)) {
                    cnt1 += nums[i] - Math.min(left, right) + 1;
                }
            } else {
                // 奇数位比左右两边都小方案
                if (nums[i] >= Math.min(left, right)) {
                    cnt2 += nums[i] - Math.min(left, right) + 1;
                }
            }
        }
        // 取两种方案最小代价
        return Math.min(cnt1, cnt2);
    }
}
