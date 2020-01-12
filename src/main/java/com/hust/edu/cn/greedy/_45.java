package com.hust.edu.cn.greedy;

class _45 {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int cnt = 1;
        int max1 = nums[0], max2 = max1;
        for (int i = 1; i < nums.length; i++) {
            if (i > max1) {
                cnt++;
                max1 = max2;
            }
            max2 = Math.max(max2, i + nums[i]);
        }
        return cnt;
    }
}
