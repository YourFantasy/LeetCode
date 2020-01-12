package com.hust.edu.cn.array;

class _724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 2) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum - nums[0] == 0) {
            return 0;
        }
        int left = nums[0], right = sum;
        for (int i = 1; i < n; i++) {
            right -= nums[i];
            left += nums[i - 1];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
