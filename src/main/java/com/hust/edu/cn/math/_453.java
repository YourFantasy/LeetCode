package com.hust.edu.cn.math;

class _453 {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = nums[0];
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return sum - min * nums.length;
    }
}
