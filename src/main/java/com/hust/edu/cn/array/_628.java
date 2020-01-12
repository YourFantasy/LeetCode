package com.hust.edu.cn.array;

import java.util.Arrays;

class _628 {
    public int maximumProduct(int[] nums) {
        int result;
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[len - 1] <= 0 || nums[0] >= 0) {
            result = nums[len - 1] * nums[len - 2] * nums[len - 3];
        } else {
            int x1 = nums[0] * nums[1] * nums[len - 1];
            int x2 = nums[len - 1] * nums[len - 2] * nums[len - 3];
            result = Math.max(x1, x2);
        }
        return result;
    }
}
