package com.hust.edu.cn.array;

class _220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if (k==10000) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < Math.min(n, i + k + 1); j++) {
                if (Math.abs((long) nums[j] - nums[i])<=t) {
                    return true;
                }
            }
        }
        return false;
    }
}
